package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
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
    public boolean alreadyExist(int id) {
        Optional<Product> product = productRepository.getProducts().stream().filter(p -> p.getId() == id).findAny();
        if (product.isPresent()) {
            return  true;
        }
        return false;
    }

    @Override
    public void add(ProductRequestDto product) {

        productRepository.addProduct(convertProduct(product));


    }

    public Product convertProduct(ProductRequestDto product) {
        return mapper.map(product, Product.class);

    }

}
