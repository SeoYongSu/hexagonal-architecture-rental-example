package com.example.rent.adapter.out.persistence.jpa;

import com.example.rent.adapter.out.persistence.jpa.entity.ReturnedItemEntity;
import com.example.rent.adapter.out.persistence.jpa.repository.ReturnedItemJpaRepository;
import com.example.rent.application.port.out.rent.ReturnedItemRepository;
import com.example.rent.domain.product.Product;
import com.example.rent.domain.rent.ReturnedItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReturnedItemRepositoryAdapter implements ReturnedItemRepository {

    private final ReturnedItemJpaRepository returnedItemJpaRepository;

    @Override
    public ReturnedItem save(ReturnedItem returnedItem) {
        return null;
    }

    @Override
    public ReturnedItem getByProductLastOne(Product product) {
        return returnedItemJpaRepository.findTopByProductIdOrderByReturnedDateDesc(product.getId())
                .map(ReturnedItemEntity::toDomain)
                .orElse(null);
    }
}
