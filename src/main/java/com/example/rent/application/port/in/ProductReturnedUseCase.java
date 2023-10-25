package com.example.rent.application.port.in;

import com.example.rent.application.service.UseCase;
import com.example.rent.domain.rent.Rent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 반납 Use Case
 */
public interface ProductReturnedUseCase extends UseCase<ProductReturnedUseCase.Input, ProductReturnedUseCase.Output>{

    record Input(
        String email,
        List<String> productIds
    ) implements UseCase.InputValues{

    }

    @Getter
    @ToString
    @AllArgsConstructor
    class Output implements UseCase.OutputValues{
        private Rent rent;
    }
}
