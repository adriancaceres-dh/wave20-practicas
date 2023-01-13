package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.model.Product;

public interface IProductService {
    ProductResponseDto getProductById(int id);

    boolean alreadyExist(int id);

    ProductResponseDto add(ProductRequestDto product);
}
