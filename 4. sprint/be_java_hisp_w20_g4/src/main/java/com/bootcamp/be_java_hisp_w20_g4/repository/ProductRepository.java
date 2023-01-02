package com.bootcamp.be_java_hisp_w20_g4.repository;

import com.bootcamp.be_java_hisp_w20_g4.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    private List<Product> products = loadProducts();

    public ProductRepository(){}

    private List<Product> loadProducts() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:products.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Product>> typeRef = new TypeReference<>() {};
        List<Product> products = null;
        try {
            products = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean productExist(Product product){
        Product productRepository = products.stream().filter(p -> p.getProduct_id() == product.getProduct_id()).findFirst().orElse(null);
        if(productRepository == null) return false;
        return productRepository.equals(product);
    }

}
