package com.example.rent.application.port.out.rent;

import com.example.rent.domain.product.Product;
import com.example.rent.domain.rent.ReturnedItem;

public interface ReturnedItemRepository {

    ReturnedItem save(ReturnedItem returnedItem);


    ReturnedItem getByProductLastOne(Product product);
}
