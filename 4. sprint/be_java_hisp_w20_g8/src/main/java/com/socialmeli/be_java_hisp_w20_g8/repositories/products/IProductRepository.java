package com.socialmeli.be_java_hisp_w20_g8.repositories.products;

import com.socialmeli.be_java_hisp_w20_g8.models.Product;

import java.util.Optional;

public interface IProductRepository {

    boolean createProduct(Product product);

    Optional<Product> getProductById(int id);
}
