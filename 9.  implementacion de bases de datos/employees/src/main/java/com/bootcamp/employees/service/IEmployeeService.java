package com.bootcamp.employees.service;

import com.bootcamp.employees.dto.EmployeeDTO;
import com.bootcamp.employees.dto.MessageDTO;

import java.util.List;

public interface IEmployeeService {

    MessageDTO createEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getEmployees();
    MessageDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
}
