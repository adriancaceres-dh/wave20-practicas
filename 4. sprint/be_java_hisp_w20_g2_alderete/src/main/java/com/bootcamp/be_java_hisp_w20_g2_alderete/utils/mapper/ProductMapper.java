package com.bootcamp.be_java_hisp_w20_g2_alderete.utils.mapper;

import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductDTO productDTO) {
        return new Product(
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes());
    }

    public ProductDTO toDTO(Product product) {
        return new ProductDTO(product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }
}