package com.bootcamp.employees.repository;

import com.bootcamp.employees.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, Long> {
}
