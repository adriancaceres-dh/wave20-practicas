package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;

public interface IProductService {
    ProductResponseDto getProductById(int id);
}
