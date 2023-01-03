package com.bootcamp.be_java_hisp_w20_g1.repository;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.model.Product;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IProductRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private List<Product> products;

    public ProductRepository() {
        this.products = buildProductRepository();

    }

    List<Product> buildProductRepository() {
        File file = null;
        try {
            file = ResourceUtils.getFile(Parameter.getString("ProductJsonPath"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Product>> typeRef = new TypeReference<>() {
        };
        List<Product> products = null;
        try {
            products = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }
    @Override
    public List<Product> getProducts() {
        return products;
    }
    @Override
    public Product addProduct(Product p) {
        products.add(p);
        return p;
    }

}
