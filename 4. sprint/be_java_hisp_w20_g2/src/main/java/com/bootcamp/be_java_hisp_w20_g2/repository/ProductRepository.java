package com.bootcamp.be_java_hisp_w20_g2.repository;

import com.bootcamp.be_java_hisp_w20_g2.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository {
    private final HashMap<Integer, Product> products;
    private static int currentId = 0;

    public ProductRepository(){
        products = new HashMap<>();
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(currentId++);
        }
        products.put(product.getId(), product);
        return product;
    }

    public Product findOne(int id) {
        return products.get(id);
    }
}
