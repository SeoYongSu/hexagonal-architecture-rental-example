package com.example.rent.adapter.out.persistence.jpa.entity;

import com.example.rent.domain.customer.Customer;
import com.example.rent.domain.rent.Rent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@ToString
@Entity
@NoArgsConstructor
public class RentEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String custerId;
    private String customerEmail;
    private String customerName;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "rent",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true
    )
    private Set<RentedItemEntity> rentedItems;


    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "rent",
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            orphanRemoval = true
    )
    private Set<ReturnedItemEntity> returnedItems;

    public RentEntity(Long id, String custerId, String customerEmail, String customerName, Set<RentedItemEntity> rentedItems, Set<ReturnedItemEntity> returnedItems) {
        this.id = id;
        this.custerId = custerId;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.rentedItems = rentedItems;
        this.returnedItems = returnedItems;
    }

    public void addRentedItem(RentedItemEntity rentedItem){
        if(this.rentedItems == null)
            this.rentedItems = new HashSet<>();
        this.rentedItems.add(rentedItem);
        rentedItem.setRent(this);
    }

    public void addReturnedItem(ReturnedItemEntity returnedItem){
        if(this.returnedItems == null)
            this.returnedItems = new HashSet<>();
        returnedItems.add(returnedItem);
        returnedItem.setRent(this);
    }

    public static RentEntity toJpaEntity(Rent rent){
        Long id = rent.getId() != null ? Long.valueOf(rent.getId()) : null;

        RentEntity entity = new RentEntity(
                  id
                , rent.getCustomer().getCustomerId()
                , rent.getCustomer().getEmail()
                , rent.getCustomer().getName()
                , new HashSet<>()
                , new HashSet<>()
        );

        rent.getRentedItems().forEach(
                rentedItem -> entity.addRentedItem(RentedItemEntity.toJpaEntity(rentedItem))
        );

        rent.getReturnedItems().forEach(
                returnedItem -> entity.addReturnedItem(ReturnedItemEntity.toJpaEntity(returnedItem))
        );

        return entity;
    }

    public Rent toDomain(){
        return new Rent(
                  new Rent.RentId(this.id.toString())
                , new Customer(this.custerId, this.customerEmail, this.customerName, null)
                , this.rentedItems.stream().map(RentedItemEntity::toDomain).collect(Collectors.toList())
                , this.returnedItems.stream().map(ReturnedItemEntity::toDomain).collect(Collectors.toList())
        );
    }


}
