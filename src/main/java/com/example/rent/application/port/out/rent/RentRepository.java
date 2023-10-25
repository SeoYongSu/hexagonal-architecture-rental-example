package com.example.rent.application.port.out.rent;

import com.example.rent.domain.rent.Rent;

public interface RentRepository {

    Rent save(Rent rent);

}
