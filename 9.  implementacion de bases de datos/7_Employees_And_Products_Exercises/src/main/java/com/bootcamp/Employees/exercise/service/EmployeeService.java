package com.bootcamp.Employees.exercise.service;

import com.bootcamp.Employees.exercise.dto.EmployeeRequestDTO;
import com.bootcamp.Employees.exercise.model.Employee;
import com.bootcamp.Employees.exercise.repository.IEmployeeRepository;
import com.bootcamp.Employees.exercise.service.intefaces.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    private final ModelMapper mapper= new ModelMapper();

    public Boolean newEmployee(EmployeeRequestDTO employeeRequestDTO){
        iEmployeeRepository.save(mapper.map(employeeRequestDTO, Employee.class));
        return true;
    }

    public Boolean updateEmployee(EmployeeRequestDTO employeeRequestDTO, Integer id){
        Employee employee = mapper.map(employeeRequestDTO, Employee.class);
        employee.setId(id);
        iEmployeeRepository.save(employee);
        return true;
    }

    public Employee readEmployee(Integer id){
        return iEmployeeRepository.findById(id).orElseThrow(()->new RuntimeException("NOT FOUND"));
    }

}
