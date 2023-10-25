package com.example.rent.adapter.out.persistence.jpa.entity;

import com.example.rent.domain.product.Book;
import com.example.rent.domain.product.Product;
import com.example.rent.domain.product.Video;
import com.example.rent.domain.rent.RentedItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class RentedItemEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String productId;
    private String productName;
    private String productType;

    private LocalDate expirationDate;
    private LocalDateTime rentDate;

//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rent_id", nullable = false)
    private RentEntity rent;

    public RentedItemEntity(Long id, String productId, String productName, String productType, LocalDate expirationDate, LocalDateTime rentDate, RentEntity rent) {
        this.id = id;
        this.productId = productId;
        this.productName= productName;
        this.productType = productType;
        this.expirationDate = expirationDate;
        this.rentDate = rentDate;

    }

    public void setRent(RentEntity rent){
        this.rent = rent;
    }


    public static RentedItemEntity toJpaEntity(RentedItem rentedItem){
        Long id = rentedItem.getId() != null ? Long.valueOf(rentedItem.getId()) : null;
        return new RentedItemEntity(
                  id
                , rentedItem.getProduct().getId()
                , rentedItem.getProduct().getName()
                , rentedItem.getProduct().getProductType()
                , rentedItem.getExpirationDate()
                , rentedItem.getRentedDate()
                , null
        );
    }

    public RentedItem toDomain(){
        Product product = switch (this.productType) {
            case "Video" -> new Video(this.productId, this.productName, null);
            case "BOOK" -> new Book(this.productId, this.productName);
            default -> throw new IllegalArgumentException("Product Type Error");
        };

        return new RentedItem(
                  new RentedItem.RentedItemId(this.id.toString())
                , product
                , this.rentDate
                , this.expirationDate
        );
    }
}
