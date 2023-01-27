package com.bootcamp.Employees.exercise.repository;

import com.bootcamp.Employees.exercise.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IProductRepository extends ElasticsearchRepository<Product,Integer> {
}
