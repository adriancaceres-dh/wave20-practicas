package com.bootcamp.ElasticSpring.repository;

import com.bootcamp.ElasticSpring.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {

    @Override
    List<Employee> findAll();
}
