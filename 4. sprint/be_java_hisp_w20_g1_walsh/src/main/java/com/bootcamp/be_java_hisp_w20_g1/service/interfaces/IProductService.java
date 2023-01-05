package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;

public interface IProductService {
    ProductResponseDto getProductById(int id);
    boolean checkIfIsIdentical(ProductRequestDto product);
    boolean alreadyExist(int id);
    void add(ProductRequestDto product);
}
