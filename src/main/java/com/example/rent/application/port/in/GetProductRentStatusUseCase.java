package com.example.rent.application.port.in;


import com.example.rent.application.service.UseCase;
import com.example.rent.domain.product.Product;
import com.example.rent.domain.rent.RentalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

public interface GetProductRentStatusUseCase extends UseCase<GetProductRentStatusUseCase.Input, GetProductRentStatusUseCase.Output>{

    record Input(
        Product product
    ) implements UseCase.InputValues{

    }

    @Getter
    @AllArgsConstructor
    class Output implements UseCase.OutputValues{
        private RentalStatus status;
    }
}
