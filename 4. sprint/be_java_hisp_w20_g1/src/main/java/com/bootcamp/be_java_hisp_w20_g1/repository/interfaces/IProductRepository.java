package com.bootcamp.be_java_hisp_w20_g1.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.model.Product;

public interface IProductRepository {
    Product getProductById(int id);
}
