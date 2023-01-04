package com.socialmeli.be_java_hisp_w20_g8.services.products;

import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Product;

public interface IProductService {
    boolean createProduct(ProductDTO productDTO);

    ProductDTO getProductById(int productId);
}
