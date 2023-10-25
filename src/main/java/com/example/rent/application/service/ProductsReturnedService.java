package com.example.rent.application.service;

import com.example.rent.application.port.in.ProductReturnedUseCase;
import com.example.rent.application.port.out.customer.CustomerServicePort;
import com.example.rent.application.port.out.product.ProductServicePort;
import com.example.rent.application.port.out.rent.RentRepository;
import com.example.rent.domain.customer.Customer;
import com.example.rent.domain.product.Product;
import com.example.rent.domain.rent.Rent;
import com.example.rent.domain.rent.ReturnedItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsReturnedService implements ProductReturnedUseCase {

    private final CustomerServicePort customerServicePort;
    private final RentRepository rentRepository;
    private final ProductServicePort productServicePort;

    @Override
    public Output execute(Input input) {
        Customer customer = customerServicePort.getByEmail(input.email());

        List<ReturnedItem> returnedItems = new ArrayList<>();
        for(String productId : input.productIds()){
            Product product = productServicePort.getById(productId);
            returnedItems.add(ReturnedItem.newInstance(product));
        }

        Rent rent = Rent.newInstance(customer, null, returnedItems);
        return new Output(rentRepository.save(rent));
    }
}
