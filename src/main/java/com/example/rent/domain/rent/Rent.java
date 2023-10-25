package com.example.rent.domain.rent;


import com.example.rent.domain.customer.Customer;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.util.*;

/**
 * 대여
 */
@ToString
@Getter
public class Rent {

    private final RentId id;

    @Value
    public static class RentId{
        String value;
        public RentId(String string) {
            this.value = string;
        }
        public static RentId createUUID(){
            return new RentId(UUID.randomUUID().toString());
        }
        public static RentId createLongID(){
            Long longId = Long.MIN_VALUE;
            return new RentId(String.valueOf(longId));
        }
    }

    /**
     * 고객
     */
    private final Customer customer;

    /**
     * 대여 한 Items
     */
    private final List<RentedItem> rentedItems;

    /**
     * 반납 한 Items
     */
    private final List<ReturnedItem> returnedItems;


    public Rent(RentId id, Customer customer, List<RentedItem> rentedItems, List<ReturnedItem> returnedItems) {
        this.id = id;
        this.customer = customer;
        this.rentedItems = rentedItems;
        this.returnedItems = returnedItems;
    }

    public static Rent newInstance(Customer customer, List<RentedItem> rentedItems, List<ReturnedItem> returnedItems){
        if(customer == null){
            throw new IllegalArgumentException("Customer is Not null");
        }

        if(rentedItems == null){
            rentedItems = new ArrayList<>();
        }
        if(returnedItems == null)
            returnedItems = new ArrayList<>();
        return new Rent(null, customer, rentedItems, returnedItems);
    }

    public String getId(){
        if(this.id == null || this.id.value == null || this.id.value.isEmpty())
            return null;
        return this.id.value;
    }

    /**
     * 대여 아이템 추가
     */
    public void addRentedItem(RentedItem rentedItem){

    }

    /**
     * 반납 아이템 추가
     */
    public void addReturnedItem(ReturnedItem returnedItem){

    }


}
