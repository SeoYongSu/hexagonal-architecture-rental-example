package com.example.rent.application.port.in;

import com.example.rent.application.service.UseCase;
import com.example.rent.domain.rent.Rent;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 제품 대여 UseCase
 */
public interface ProductsRentalUseCase {

    Output execute(Input input);

    record Input(
        String email,
        List<String> productIds,
        Integer rentalPeriod
    ) implements UseCase.InputValues{

    }

    @Getter
    @AllArgsConstructor
    class Output implements UseCase.OutputValues{
        private Rent rent;
    }
}
