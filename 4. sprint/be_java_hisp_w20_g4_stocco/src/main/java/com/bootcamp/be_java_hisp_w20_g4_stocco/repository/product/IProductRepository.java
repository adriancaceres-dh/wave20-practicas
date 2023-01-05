package com.bootcamp.be_java_hisp_w20_g4_stocco.repository.product;

import com.bootcamp.be_java_hisp_w20_g4_stocco.model.Product;

public interface IProductRepository {
    public boolean productExist(Product product);
    public Product findById(Product product);
}
