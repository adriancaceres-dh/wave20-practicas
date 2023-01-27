package com.bootcamp.Employees.exercise.repository;

import com.bootcamp.Employees.exercise.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee,Integer> {

}
