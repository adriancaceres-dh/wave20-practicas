package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g1.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g1.model.Product;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IProductService;
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

    @Override
    public ProductResponseDto modifyProduct(ProductRequestDto productRequestDto,  ProductResponseDto productResponseDto) {
        if (productRequestDto.getProductId() != productResponseDto.getProductId())
            throw new BadRequestException(Parameter.getString("EX_InvalidRequestBody"));
        Product product = productRepository.getProductById(productRequestDto.getProductId());
        product.setBrand(productRequestDto.getBrand());
        product.setColor(productRequestDto.getColor());
        product.setType(productRequestDto.getType());
        product.setName(productRequestDto.getProductName());
        product.setNotes(productRequestDto.getNotes());
        return mapper.map(product, ProductResponseDto.class);

    }

}
