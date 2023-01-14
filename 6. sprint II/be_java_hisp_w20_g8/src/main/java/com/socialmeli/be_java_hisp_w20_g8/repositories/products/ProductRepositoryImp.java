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
        loadProducts();
    }

    @Override
    public boolean createProduct(Product product) {
        return products.add(product);
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return products.stream().filter(product -> product.getProduct_id() == id).findFirst();
    }

    private void loadProducts() {
        products.add(new Product(1, "Television", "Technology", "Samsung", "Black", "TV 68 inches"));
        products.add(new Product(2, "Freezer", "Technology", "Samsung", "Black", "Freezer"));
        products.add(new Product(3, "Blender", "Technology", "Samsung", "Black", "9 liters"));
        products.add(new Product(4, "Shirt", "Clothes", "Woft", "Black", "Sports shirt"));
    }
}
