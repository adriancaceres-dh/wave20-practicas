package com.bootcamp.Employees.exercise.service.intefaces;

import com.bootcamp.Employees.exercise.dto.EmployeeRequestDTO;
import com.bootcamp.Employees.exercise.model.Employee;

public interface IEmployeeService {

    Boolean newEmployee(EmployeeRequestDTO employeeRequestDTO);
    Boolean updateEmployee(EmployeeRequestDTO employeeRequestDTO, Integer id);
    Employee readEmployee(Integer id);
}
