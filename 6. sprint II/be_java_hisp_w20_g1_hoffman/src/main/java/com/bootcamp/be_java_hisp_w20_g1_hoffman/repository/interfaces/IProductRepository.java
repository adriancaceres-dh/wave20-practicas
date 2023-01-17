package com.bootcamp.be_java_hisp_w20_g1_hoffman.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_hoffman.model.Product;

import java.util.List;

public interface IProductRepository {
    Product getProductById(int id);

    List<Product> getProducts();

    Product addProduct(Product p);
}
