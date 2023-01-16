package com.bootcamp.be_java_hisp_w20_g1_ramosruiz.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.request.ProductRequestDto;

public interface IProductService {
    ProductResponseDto getProductById(int id);

    boolean alreadyExist(int id);

    ProductResponseDto add(ProductRequestDto product);
}
