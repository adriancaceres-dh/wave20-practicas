package com.bootcamp.be_java_hisp_w20_g1_hoffman.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.request.ProductRequestDto;

public interface IProductService {
    ProductResponseDto getProductById(int id);

    boolean alreadyExist(int id);

    ProductResponseDto add(ProductRequestDto product);
}
