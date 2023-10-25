package com.example.rent.domain.customer;

import lombok.Value;

/**
 * 고객
 */
@Value
public class Customer {

    String customerId;
    String email;
    String name;
    String address;

}
