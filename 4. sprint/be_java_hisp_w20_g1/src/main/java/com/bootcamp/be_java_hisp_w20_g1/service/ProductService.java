package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.model.Product;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public ProductResponseDto getProductById(int id) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            return ProductResponseDto.builder()
                    .productId(id)
                    .productName(product.getName())
                    .type(product.getType())
                    .brand(product.getBrand())
                    .color(product.getColor())
                    .notes(product.getNotes())
                    .build();
        } else {
            throw new RuntimeException("produto no existente");
        }
    }
}
