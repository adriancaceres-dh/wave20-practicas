package com.bootcamp.be_java_hisp_w20_g4.repository.product;

import com.bootcamp.be_java_hisp_w20_g4.model.Product;

public interface IProductRepository {
    public boolean productExist(Product product);

}
