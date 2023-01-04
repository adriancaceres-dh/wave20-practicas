package com.bootcamp.be_java_hisp_w20_g1_demarchi.service;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.Product;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.repository.interfaces.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.service.interfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ModelMapper mapper;

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
            throw new NotFoundException(Parameter.getString("EX_NotExistentProduct"));
        }
    }

    public boolean alreadyExist(int id) {
        Optional<Product> product = productRepository.getProducts().stream().filter(p -> p.getId() == id).findAny();
        return product.isPresent();
    }

    @Override
    public void add(ProductRequestDto product) {
        productRepository.addProduct(convertProduct(product));
    }

    public Product convertProduct(ProductRequestDto product) {
        return mapper.map(product, Product.class);
    }

}
