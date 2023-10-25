package com.example.rent.adapter.out.persistence.jpa.entity;

import com.example.rent.domain.product.Book;
import com.example.rent.domain.product.Product;
import com.example.rent.domain.product.Video;
import com.example.rent.domain.rent.ReturnedItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Entity
@NoArgsConstructor
public class ReturnedItemEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String productId;
    private String productName;
    private String productType;

    private LocalDateTime returnedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rent_id", nullable = false)
    private RentEntity rent;

    public ReturnedItemEntity(Long id, String productId, String productName, String productType, LocalDateTime returnedDate) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.returnedDate = returnedDate;
    }

    public void setRent(RentEntity rent){
        this.rent = rent;
    }


    public static ReturnedItemEntity toJpaEntity(ReturnedItem returnedItem){
        Long id = returnedItem.getId() != null ? Long.valueOf(returnedItem.getId()) : null;
        return new ReturnedItemEntity(
                  id
                , returnedItem.getProduct().getId()
                , returnedItem.getProduct().getName()
                , returnedItem.getProduct().getProductType()
                , returnedItem.getReturnedDate()
        );
    }

    public ReturnedItem toDomain(){
        Product product = switch (this.productType) {
            case "Video" -> new Video(this.productId, this.productName, null);
            case "BOOK" -> new Book(this.productId, this.productName);
            default -> throw new IllegalArgumentException("Product Type Error");
        };
        return new ReturnedItem(
                  new ReturnedItem.ReturnedItemId(this.id.toString())
                , product
                , this.returnedDate
        );
    }

}
