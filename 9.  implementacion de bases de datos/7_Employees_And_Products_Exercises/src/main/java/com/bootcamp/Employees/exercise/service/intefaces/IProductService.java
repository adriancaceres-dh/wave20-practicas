package com.bootcamp.Employees.exercise.service.intefaces;

import com.bootcamp.Employees.exercise.dto.EmployeeRequestDTO;
import com.bootcamp.Employees.exercise.dto.ProductRequestDTO;
import com.bootcamp.Employees.exercise.model.Employee;
import com.bootcamp.Employees.exercise.model.Product;

public interface IProductService {

    Boolean newProduct(ProductRequestDTO productRequestDTO);
    Boolean updateProduct(ProductRequestDTO productRequestDTO, Integer id);
    Product readProduct(Integer id);
}
