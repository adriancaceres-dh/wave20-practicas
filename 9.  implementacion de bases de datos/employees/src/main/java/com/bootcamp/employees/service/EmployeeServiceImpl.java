package com.bootcamp.employees.service;

import com.bootcamp.employees.dto.EmployeeDTO;
import com.bootcamp.employees.dto.MessageDTO;
import com.bootcamp.employees.domain.Employee;
import com.bootcamp.employees.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;
    ModelMapper modelMapper = new ModelMapper();

    public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public MessageDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = modelMapper.map(employeeDTO, Employee.class);
        newEmployee = employeeRepository.save(newEmployee);

        return new MessageDTO(201, "Created", "The employee was created with the following ID: " + newEmployee.getId() + ".");
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        Page<Employee> employees = employeeRepository.findAll(Pageable.unpaged());

        return employees.map(employee -> modelMapper.map(employee, EmployeeDTO.class)).toList();
    }

    @Override
    public MessageDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        if(!id.equals(employeeDTO.getId()))
            throw new RuntimeException("The endpoint ID must match the payload ID.");

        if(!employeeRepository.existsById(employeeDTO.getId()))
            throw new RuntimeException("Employee not found.");

        Employee newEmployee = modelMapper.map(employeeDTO, Employee.class);
        employeeRepository.save(newEmployee);

        return new MessageDTO(200, "Updated", "The employee was updated.");
    }
}
