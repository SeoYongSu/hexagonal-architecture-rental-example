package com.example.rent.domain.product;

import lombok.Getter;
import lombok.ToString;

/**
 * 제품 : Book
 */
@ToString
@Getter
public class Book implements Product {

    private String id;


    private String name;



    public Book(String id, String productName) {
        this.id = id;
        this.name = productName;
    }





    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public String getProductType() {
        return "BOOK";
    }
}
