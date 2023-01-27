package com.bootcamp.Employees.exercise.service;

import com.bootcamp.Employees.exercise.dto.ProductRequestDTO;
import com.bootcamp.Employees.exercise.model.Product;
import com.bootcamp.Employees.exercise.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServide {

    @Autowired
    private IProductRepository iProductRepository;

    private final ModelMapper mapper = new ModelMapper();


    public Boolean newProduct(ProductRequestDTO productRequestDTO){
        iProductRepository.save(mapper.map(productRequestDTO, Product.class));
        return true;
    }
    public Boolean updateProduct(ProductRequestDTO productRequestDTO, Integer id) {
        Product product = mapper.map(productRequestDTO,Product.class);
        product.setId(id);
        return true;
    }
    public Product readProduct(Integer id){
        return iProductRepository.findById(id).orElseThrow(()-> new RuntimeException("NOT FOUND"));
    }
}
