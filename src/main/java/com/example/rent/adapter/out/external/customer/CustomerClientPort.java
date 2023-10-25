package com.example.rent.adapter.out.external.customer;

import com.example.rent.domain.customer.Customer;
import com.example.rent.application.port.out.customer.CustomerServicePort;
import org.springframework.stereotype.Component;

/**
 * 여기서는 그냥 외부통신 이용했다고 가정함
 * 내외부 시스템 연동 구현
 */
@Component
public class CustomerClientPort implements CustomerServicePort {

    @Override
    public Customer getByEmail(String email) {
        String customerId = "user_id";
        String name = "홍길동";
        String address = "서울시 강남구 ...";
        return new Customer(customerId, email, name, address);
    }

}
