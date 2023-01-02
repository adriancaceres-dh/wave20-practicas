package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.model.Product;

public interface IProductService {
    boolean alreadyExist(int id);

    void add(ProductRequestDto product);
}
