package com.example.rent.application.port.out.customer;

import com.example.rent.domain.customer.Customer;


public interface CustomerServicePort {
    Customer getByEmail(String email);

}
