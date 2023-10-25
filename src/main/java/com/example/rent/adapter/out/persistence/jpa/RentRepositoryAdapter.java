package com.example.rent.adapter.out.persistence.jpa;

import com.example.rent.adapter.out.persistence.jpa.entity.RentEntity;
import com.example.rent.adapter.out.persistence.jpa.repository.RentJpaRepository;
import com.example.rent.application.port.out.rent.RentRepository;
import com.example.rent.domain.rent.Rent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RentRepositoryAdapter implements RentRepository {

    private final RentJpaRepository rentJpaRepository;

    @Override
    public Rent save(Rent rent) {
        RentEntity entity = RentEntity.toJpaEntity(rent);
        return rentJpaRepository.save(entity).toDomain();
    }
}
