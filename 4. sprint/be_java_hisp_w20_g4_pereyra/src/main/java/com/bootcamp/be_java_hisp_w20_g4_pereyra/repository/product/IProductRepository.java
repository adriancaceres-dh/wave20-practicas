package com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.product;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Product;

public interface IProductRepository {
    boolean productExist(Product product);
    boolean addProduct(Product productToAdd);
}
