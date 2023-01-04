package com.bootcamp.be_java_hisp_w20_g1_demarchi.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.ProductRequestDto;

public interface IProductService {
    ProductResponseDto getProductById(int id);

    boolean alreadyExist(int id);

    void add(ProductRequestDto product);
}
