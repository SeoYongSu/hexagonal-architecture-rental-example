package com.example.rent.application.service;

import com.example.rent.application.port.in.GetProductRentStatusUseCase;
import com.example.rent.application.port.in.ProductsRentalUseCase;
import com.example.rent.application.port.out.customer.CustomerServicePort;
import com.example.rent.application.port.out.product.ProductServicePort;
import com.example.rent.application.port.out.rent.RentRepository;
import com.example.rent.domain.customer.Customer;
import com.example.rent.domain.product.Product;
import com.example.rent.domain.rent.Rent;
import com.example.rent.domain.rent.RentedItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsRentalService implements ProductsRentalUseCase {
    private final CustomerServicePort customerServicePort;
    private final ProductServicePort productServicePort;

    private final RentRepository rentRepository;

    private final GetProductRentStatusUseCase getProductRentStatusUseCase;

    @Override
    public Output execute(Input input) {
        Customer customer = customerServicePort.getByEmail(input.email());

        List<RentedItem> rentedItems = new ArrayList<>();
        for(String productId : input.productIds()){
            Product product = productServicePort.getById(productId);
            RentedItem rentedItem = RentedItem.newInstance(product, input.rentalPeriod());

            //대여 상태 확인 등의 비지니스 추가해도됨~
            GetProductRentStatusUseCase.Output status = getProductRentStatusUseCase.execute(new GetProductRentStatusUseCase.Input(product));
            if(status.getStatus().getId()==0){
                rentedItems.add(rentedItem);
            }

        }

        Rent rent = Rent.newInstance(customer, rentedItems, null);
        return new Output(rentRepository.save(rent));
    }
}
