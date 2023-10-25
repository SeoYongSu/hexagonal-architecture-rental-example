package com.example.rent.adapter.in.web;

import com.example.rent.application.port.in.GetProductUseCase;
import com.example.rent.application.port.in.GetProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductsController {


    private final GetProductUseCase getProductUseCase;

    @GetMapping("/product/{productId}")
    public GetProductUseCase.Output product(@PathVariable("productId") String productId){
        return getProductUseCase.execute(new GetProductUseCase.Input(productId));
    }

    private final GetProductsUseCase getProductsUseCase;
    @GetMapping("/products")
    public GetProductsUseCase.Output products(){
        return getProductsUseCase.execute(null);
    }
}
