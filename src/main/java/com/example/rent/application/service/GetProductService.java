package com.example.rent.application.service;

import com.example.rent.application.port.in.GetProductRentStatusUseCase;
import com.example.rent.application.port.in.GetProductUseCase;
import com.example.rent.application.port.out.product.ProductServicePort;
import com.example.rent.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductService implements GetProductUseCase {

    private final ProductServicePort productServicePort;
    private final GetProductRentStatusUseCase getProductRentStatusUseCase;
    @Override
    public Output execute(Input input) {
        Product product = productServicePort.getById(input.productId());
        GetProductRentStatusUseCase.Output status = getProductRentStatusUseCase.execute(new GetProductRentStatusUseCase.Input(product));
        return new Output(product,status.getStatus());
    }
}
