package com.bootcamp.be_java_hisp_w20_g1_demarchi.repository;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.Product;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.repository.interfaces.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.util.JsonReaderUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private final List<Product> products;

    public ProductRepository() {
        this.products = JsonReaderUtil.parseJson(Parameter.getString("ProductJsonPath"), Product.class);
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
