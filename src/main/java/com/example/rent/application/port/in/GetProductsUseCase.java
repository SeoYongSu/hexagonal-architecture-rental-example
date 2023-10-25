package com.example.rent.application.port.in;

import com.example.rent.application.service.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
public interface GetProductsUseCase extends UseCase<UseCase.InputValues, GetProductsUseCase.Output>{


    @Getter
    @AllArgsConstructor
    class Output implements UseCase.OutputValues{
        private List<GetProductUseCase.Output> products;
    }
}
