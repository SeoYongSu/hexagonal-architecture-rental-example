package com.example.rent.domain.product;

import lombok.Getter;
import lombok.ToString;

/**
 * 제품 : Video
 */
@Getter
@ToString
public class Video implements Product {

    private String id;

    private String name;

    private Integer durationMinutes;

    public Video(String id, String name, Integer durationMinutes) {
        this.id = id;
        this.name = name;
        this.durationMinutes = durationMinutes;
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
        return "Video";
    }





}
