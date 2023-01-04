package com.bootcamp.be_java_hisp_w20_g1_demarchi.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.Product;

public interface IProductService {
    Product getProductById(int id);

    boolean alreadyExist(int id);

    void add(ProductRequestDto product);
}
