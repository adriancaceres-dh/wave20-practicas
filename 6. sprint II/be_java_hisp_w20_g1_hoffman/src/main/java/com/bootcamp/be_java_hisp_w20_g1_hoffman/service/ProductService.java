package com.bootcamp.be_java_hisp_w20_g1_hoffman.service;

import com.bootcamp.be_java_hisp_w20_g1_hoffman.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.model.Product;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.repository.interfaces.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.service.interfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {


    private ModelMapper mapper;


    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

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
            throw new NotFoundException(Parameter.getString("EX_NotExistentProduct"));
        }
    }

    public boolean alreadyExist(int id) {
        Optional<Product> product = productRepository.getProducts().stream().filter(p -> p.getId() == id).findAny();
        return product.isPresent();
    }

    @Override
    public ProductResponseDto  add(ProductRequestDto product) {
        return mapper.map(productRepository.addProduct(convertProduct(product)), ProductResponseDto.class);
    }

    private Product convertProduct(ProductRequestDto product) {
        return mapper.map(product, Product.class);
    }

}
