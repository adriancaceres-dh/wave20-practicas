package com.bootcamp.ElasticSpring.service;

import com.bootcamp.ElasticSpring.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    //CRUD
    public String addEmployee(EmployeeDTO employeeDTO);

    public List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO getEmployeeById(String id);

    public String updateEmployee(EmployeeDTO employeeDTO);

    public String deleteEmployee(String id);

}
