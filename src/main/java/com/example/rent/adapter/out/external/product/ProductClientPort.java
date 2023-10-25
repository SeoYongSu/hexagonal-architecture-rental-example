package com.example.rent.adapter.out.external.product;

import com.example.rent.domain.product.Book;
import com.example.rent.domain.product.Product;
import com.example.rent.domain.product.Video;
import com.example.rent.application.port.out.product.ProductServicePort;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductClientPort implements ProductServicePort {

    private List<Product> productsStore;

    @PostConstruct
    private void initSampleData(){
        productsStore = new ArrayList<>();
        productsStore.add( new Book("Book_1", "Clean Architecture"));
        productsStore.add( new Book("Book_2", "WellCom Python"));
        productsStore.add( new Book("Book_3", "Hello Java"));
        productsStore.add( new Video("Video_1", "Spring Boot Let Go",60));
        productsStore.add( new Video("Video_2", "WebFlux MAS Example", 120));

    }

    @Override
    public List<Product> getProducts() {
        return productsStore;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        for(Product product : productsStore){
            if(product.getProductType().equals("BOOK"))
                books.add((Book) product);
        }

        return books;
    }

    @Override
    public List<Video> getVideos() {
        List<Video> videos = new ArrayList<>();
        for(Product product : productsStore){
            if(product.getProductType().equals("Videos"))
                videos.add((Video) product);
        }
        return videos;
    }

    @Override
    public Product getById(String productId) {
        for(Product product : productsStore){
            if(product.getId().equals(productId))
                return product;
        }
        throw new RuntimeException("상품이 존재하지 않습니다.");
    }

    @Override
    public Product getByProductName(String productName) {
        return null;
    }

    @Override
    public Product addRequest(Product product) {
        productsStore.add(product);
        return product;
    }
}
