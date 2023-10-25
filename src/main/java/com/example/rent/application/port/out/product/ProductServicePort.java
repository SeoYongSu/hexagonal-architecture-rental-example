package com.example.rent.application.port.out.product;

import com.example.rent.domain.product.Book;
import com.example.rent.domain.product.Product;
import com.example.rent.domain.product.Video;

import java.util.List;

public interface ProductServicePort {

    List<Product> getProducts();

    List<Book> getBooks();

    List<Video> getVideos();


    Product getById(String productId);
    Product getByProductName(String productName);



    /**
     * 새로운 제품을 등록해 달라고 가정함
     */
    Product addRequest(Product product);

}
