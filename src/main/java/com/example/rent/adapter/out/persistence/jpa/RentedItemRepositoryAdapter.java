package com.example.rent.adapter.out.persistence.jpa;

import com.example.rent.adapter.out.persistence.jpa.entity.RentedItemEntity;
import com.example.rent.adapter.out.persistence.jpa.repository.RentedItemJpaRepository;
import com.example.rent.application.port.out.rent.RentedItemRepository;
import com.example.rent.domain.product.Product;
import com.example.rent.domain.rent.RentedItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RentedItemRepositoryAdapter implements RentedItemRepository {

    private final RentedItemJpaRepository rentedItemJpaRepository;

    @Override
    public RentedItem save(RentedItem rentedItem) {
        RentedItemEntity entity = RentedItemEntity.toJpaEntity(rentedItem);
        return rentedItemJpaRepository.save(entity).toDomain();
    }

    @Override
    public RentedItem getByProductLastOne(Product product) {
        return rentedItemJpaRepository.findTopByProductIdOrderByExpirationDateDesc(product.getId())
                .map(RentedItemEntity::toDomain)
                .orElse(null);
    }
}
