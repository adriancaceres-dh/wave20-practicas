package com.bootcamp.products.service;

import com.bootcamp.products.dto.ProductDTO;
import com.bootcamp.products.dto.MessageDTO;
import com.bootcamp.products.domain.Product;
import com.bootcamp.products.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public MessageDTO createProduct(ProductDTO productDTO) {
        Product newProduct = modelMapper.map(productDTO, Product.class);
        newProduct = productRepository.save(newProduct);

        return new MessageDTO(201, "Created", "The product was created with the following ID: " + newProduct.getId() + ".");
    }

    @Override
    public List<ProductDTO> getProducts() {
        Page<Product> products = productRepository.findAll(Pageable.unpaged());

        return products.map(product -> modelMapper.map(product, ProductDTO.class)).toList();
    }

    @Override
    public MessageDTO updateProduct(Long id, ProductDTO productDTO) {
        if(!id.equals(productDTO.getId()))
            throw new RuntimeException("The endpoint ID must match the payload ID.");

        if(!productRepository.existsById(productDTO.getId()))
            throw new RuntimeException("Product not found.");

        Product newProduct = modelMapper.map(productDTO, Product.class);
        productRepository.save(newProduct);

        return new MessageDTO(200, "Updated", "The product was updated.");
    }
}
