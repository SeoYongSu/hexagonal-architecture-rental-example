package com.example.rent.domain.rent;

import com.example.rent.domain.product.Product;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * 반납 Items
 */
@Getter
@ToString
public class ReturnedItem {

    private ReturnedItemId id;
    @Value
    public static class ReturnedItemId{
        String value;
    }

    private Product product;

    private LocalDateTime returnedDate;


    public ReturnedItem(ReturnedItemId id, Product product, LocalDateTime returnedDate) {
        this.id = id;
        this.product = product;
        this.returnedDate = returnedDate;
    }

    public static ReturnedItem newInstance(Product product){
        if(product == null)
            throw new IllegalArgumentException("Product is not null");
        return new ReturnedItem(null, product, LocalDateTime.now());
    }

    public String getId(){
        if(this.id == null || this.id.value == null || this.id.value.isEmpty())
            return null;
        return this.id.value;
    }
}
