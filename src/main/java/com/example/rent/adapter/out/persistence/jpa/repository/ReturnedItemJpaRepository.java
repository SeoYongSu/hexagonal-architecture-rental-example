package com.example.rent.adapter.out.persistence.jpa.repository;

import com.example.rent.adapter.out.persistence.jpa.entity.ReturnedItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReturnedItemJpaRepository extends JpaRepository<ReturnedItemEntity, Long> {

    Optional<ReturnedItemEntity> findTopByProductIdOrderByReturnedDateDesc(String productId);
}
