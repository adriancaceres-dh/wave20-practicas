package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.repository.ProductRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    public ProductService(){

    }
}
