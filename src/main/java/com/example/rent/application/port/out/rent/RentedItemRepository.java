package com.example.rent.application.port.out.rent;

import com.example.rent.domain.product.Product;
import com.example.rent.domain.rent.RentedItem;

public interface RentedItemRepository {
    RentedItem save(RentedItem rentedItem);

    RentedItem getByProductLastOne(Product product);

}
