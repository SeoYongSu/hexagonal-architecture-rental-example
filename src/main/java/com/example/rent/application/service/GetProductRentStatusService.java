package com.example.rent.application.service;

import com.example.rent.application.port.in.GetProductRentStatusUseCase;
import com.example.rent.application.port.out.rent.RentedItemRepository;
import com.example.rent.application.port.out.rent.ReturnedItemRepository;
import com.example.rent.domain.rent.RentalStatus;
import com.example.rent.domain.rent.RentedItem;
import com.example.rent.domain.rent.ReturnedItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductRentStatusService implements GetProductRentStatusUseCase {
    private final RentedItemRepository rentedItemRepository;
    private final ReturnedItemRepository returnedItemRepository;

    @Override
    public Output execute(Input input) {

        RentedItem rentedItem = rentedItemRepository.getByProductLastOne(input.product());
        ReturnedItem returnedItem = returnedItemRepository.getByProductLastOne(input.product());

        //최종 대여 Item정보와 최종 반납 Item 정보 비교 해서 상태값 설정
        RentalStatus status;
        if (rentedItem != null && returnedItem != null) {
            if (rentedItem.getRentedDate().isBefore(returnedItem.getReturnedDate())) {
                status = RentalStatus.RENT_AVAILABLE;
            } else {
                status = RentalStatus.RENT_UNAVAILABLE;
            }
        } else if (rentedItem == null) {
            status = RentalStatus.RENT_AVAILABLE;
        } else {
            status = RentalStatus.RENT_UNAVAILABLE;
        }
        return new Output(status);
    }
}
