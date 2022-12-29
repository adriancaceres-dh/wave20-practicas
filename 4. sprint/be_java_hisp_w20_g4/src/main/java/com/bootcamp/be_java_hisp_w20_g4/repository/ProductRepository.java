package com.bootcamp.be_java_hisp_w20_g4.repository;

import com.bootcamp.be_java_hisp_w20_g4.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    private List<Product> products;




}
