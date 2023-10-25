package com.example.rent.domain.rent;

import lombok.Getter;

@Getter
public enum RentalStatus {
    RENT_AVAILABLE(0,"대여 가능","대여 가능 상태"),
    RENT_UNAVAILABLE(1,"대여 불가","대여 불가능 상태");

    private final Integer id;
    private final String subject;
    private final String description;

    RentalStatus(Integer id, String subject, String description) {
        this.id = id;
        this.subject = subject;
        this.description = description;
    }

}
