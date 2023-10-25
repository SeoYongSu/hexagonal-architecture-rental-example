package com.example.rent.adapter.out.persistence.mogodb.repository;

import com.example.rent.domain.rent.Rent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentMongoRepository extends MongoRepository<Rent, String> {
}
