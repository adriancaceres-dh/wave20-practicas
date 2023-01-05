package com.bootcamp.be_java_hisp_w20_g1_berthet.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.request.ProductRequestDto;

public interface IProductService {
    ProductResponseDto getProductById(int id);

    boolean alreadyExist(int id);

    void add(ProductRequestDto product);

    boolean matchWithExistingProduct(ProductRequestDto product);
}
