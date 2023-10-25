package com.example.rent.adapter.in.web;

import com.example.rent.application.port.in.ProductReturnedUseCase;
import com.example.rent.application.port.in.ProductsRentalUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RentController {

    private final ProductsRentalUseCase productsRentalUseCase;
    private final ProductReturnedUseCase productReturnedUseCase;

    @PostMapping("/rent")
    public ProductsRentalUseCase.Output rent(@RequestBody ProductsRentalUseCase.Input requestData){
        return productsRentalUseCase.execute(requestData);
    }

    @PostMapping("/returned")
    public ProductReturnedUseCase.Output returned(@RequestBody ProductReturnedUseCase.Input requestData){
        return productReturnedUseCase.execute(requestData);
    }
}
