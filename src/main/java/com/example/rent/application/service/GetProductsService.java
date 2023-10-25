package com.example.rent.application.service;

import com.example.rent.application.port.in.GetProductRentStatusUseCase;
import com.example.rent.application.port.in.GetProductUseCase;
import com.example.rent.application.port.in.GetProductsUseCase;
import com.example.rent.application.port.out.product.ProductServicePort;
import com.example.rent.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductsService implements GetProductsUseCase {

    private final ProductServicePort productServicePort;

    private final GetProductRentStatusUseCase getProductRentStatusUseCase;


    @Override
    public Output execute(InputValues input) {
        List<Product> productData = productServicePort.getProducts();

        List<GetProductUseCase.Output> outputs = new ArrayList<>();
        for(Product product : productData){
            GetProductRentStatusUseCase.Output status = getProductRentStatusUseCase.execute(new GetProductRentStatusUseCase.Input(product));
            GetProductUseCase.Output output = new GetProductUseCase.Output(product, status.getStatus());
            outputs.add(output);
        }


        return new Output(outputs);
    }
}
