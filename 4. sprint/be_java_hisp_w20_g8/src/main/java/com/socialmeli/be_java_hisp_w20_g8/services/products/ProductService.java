package com.socialmeli.be_java_hisp_w20_g8.services.products;


import com.socialmeli.be_java_hisp_w20_g8.dto.ProductRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Product;
import com.socialmeli.be_java_hisp_w20_g8.repositories.products.IProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProductService implements IProductService {
    private  final ModelMapper mapper = new ModelMapper();

    @Autowired
    IProductRepository productRepository;

    public ProductService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public boolean createProduct(ProductRequestDTO productRequestDTO) {
        // Check if all the product fields are present
        if(!Stream.of(productRequestDTO.getProductId(), productRequestDTO.getProductName(), productRequestDTO.getType(), productRequestDTO.getBrand(), productRequestDTO.getColor(), productRequestDTO.getNotes())
                .allMatch(Objects::nonNull))
            throw new InvalidArgumentException("All the fields are required");

        Product product = mapper.map(productRequestDTO, Product.class);
        Optional<Product> existing = productRepository.getProductById(product.getProductId());

        // Check if the product is valid
        if(existing.isPresent() && !product.equals(existing.get())) {
            throw new OperationFailedException("Another product with the same identifier is already registered");
        }

        if(existing.isEmpty())
            return productRepository.createProduct(product);

        return false;
    }
}
