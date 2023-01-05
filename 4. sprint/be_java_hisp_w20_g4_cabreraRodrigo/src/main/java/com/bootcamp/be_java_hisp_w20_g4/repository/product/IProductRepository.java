package com.bootcamp.be_java_hisp_w20_g4.repository.product;

import com.bootcamp.be_java_hisp_w20_g4.model.Product;

import java.util.List;

public interface IProductRepository {
    public boolean productExist(Product product);
    public List<Product> listAllProducts();

}
