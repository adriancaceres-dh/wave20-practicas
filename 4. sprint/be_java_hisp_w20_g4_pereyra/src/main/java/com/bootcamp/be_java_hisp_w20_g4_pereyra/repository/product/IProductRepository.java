package com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.product;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Product;

public interface IProductRepository {
    public boolean productExist(Product product);

}
