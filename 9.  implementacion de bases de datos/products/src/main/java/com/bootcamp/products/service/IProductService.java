package com.bootcamp.products.service;

import com.bootcamp.products.dto.ProductDTO;
import com.bootcamp.products.dto.MessageDTO;

import java.util.List;

public interface IProductService {

    MessageDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getProducts();
    MessageDTO updateProduct(Long id, ProductDTO productDTO);
}
