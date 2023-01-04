package com.socialmeli.be_java_hisp_w20_g8.repositories.products;

import com.socialmeli.be_java_hisp_w20_g8.models.Product;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class ProductRepositoryImp implements IProductRepository {
    private final Set<Product> products;

    public ProductRepositoryImp() {
        products = new HashSet<>();
    }

    @Override
    public boolean createProduct(Product product) {
        return products.add(product);
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return products.stream().filter(product -> product.getProductId() == id).findFirst();
    }
}
