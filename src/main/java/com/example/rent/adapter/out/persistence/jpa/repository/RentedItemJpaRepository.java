package com.example.rent.adapter.out.persistence.jpa.repository;

import com.example.rent.adapter.out.persistence.jpa.entity.RentedItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentedItemJpaRepository extends JpaRepository<RentedItemEntity, Long> {


    Optional<RentedItemEntity> findTopByProductIdOrderByExpirationDateDesc(String productId);

}
