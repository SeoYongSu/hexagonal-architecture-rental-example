package com.example.rent.adapter.out.persistence.jpa.repository;

import com.example.rent.adapter.out.persistence.jpa.entity.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentJpaRepository extends JpaRepository<RentEntity, Long> {
}
