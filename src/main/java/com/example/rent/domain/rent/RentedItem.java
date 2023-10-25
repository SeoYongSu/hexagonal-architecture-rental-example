package com.example.rent.domain.rent;

import com.example.rent.domain.product.Product;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 대여 Item
 */
@Getter
@ToString
public class RentedItem {

    private final RentedItemId id;

    @Value
    public static class RentedItemId{
        String value;
    }

    private Product product;

    private LocalDateTime rentedDate;

    private LocalDate expirationDate;

    public RentedItem(RentedItemId id, Product product, LocalDateTime rentedDate, LocalDate expirationDate) {
        this.id = id;
        this.product = product;
        this.rentedDate = rentedDate;
        this.expirationDate = expirationDate;
    }


    public static RentedItem newInstance(Product product, Integer rentalPeriod){
        if(product == null)
            throw new IllegalArgumentException("Instance Product is not null");
        if(rentalPeriod == null || rentalPeriod < 1)
            throw new IllegalArgumentException("The rental period must be at least 1 Day");
        LocalDate expirationDate = LocalDate.now().plusDays(rentalPeriod);
        return new RentedItem(null, product, LocalDateTime.now(), expirationDate);
    }

    public String getId(){
        if(this.id == null || this.id.value == null || this.id.value.isEmpty())
            return null;
        return this.id.value;
    }
}
