package com.bootcamp.be_java_hisp_w20_g2_espindola.repository;

import com.bootcamp.be_java_hisp_w20_g2_espindola.model.Product;
import com.bootcamp.be_java_hisp_w20_g2_espindola.repository.interfaces.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository implements IProductRepository {
    private int currentId = 0;
    private final HashMap<Integer, Product> products;

    public ProductRepository() {
        products = new HashMap<>();
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(currentId++);
        }
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Product findOne(Integer key) {
        return products.get(key);
    }

    @Override
    public boolean exists(Integer key) {
        return products.containsKey(key);
    }
}
