package com.bootcamp.ElasticSpring.service;

import com.bootcamp.ElasticSpring.domain.Employee;
import com.bootcamp.ElasticSpring.dto.EmployeeDTO;
import com.bootcamp.ElasticSpring.repository.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService{

    private IEmployeeRepository employeeRepository;

    private ModelMapper mapper = new ModelMapper();

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        var employee = mapper.map(employeeDTO, Employee.class);

        employee = employeeRepository.save(employee);

        return "Se ha agregado al empleado " + employeeDTO.getName() + " " + employeeDTO.getLastname() + " con id: " + employeeDTO.getId();
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        var list = employeeRepository.findAll();

        return list.stream().map(emp -> mapper.map(emp, EmployeeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(String id) {
        var employee = employeeRepository.findById(id);

        return mapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public String updateEmployee(EmployeeDTO employeeDTO) {
        if(!employeeRepository.existsById(employeeDTO.getId()))
            throw new RuntimeException("No se permite actualizar un registro con un id no válido o nulo");

        var employee = mapper.map(employeeDTO, Employee.class);

        employee = employeeRepository.save(employee);

        return "Se ha actualizado el empleado con id: " + employeeDTO.getId();
    }

    @Override
    public String deleteEmployee(String id) {
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return "Se ha eliminado el empleado con id: " + id;
        }
        else throw new RuntimeException("No se ha podido eliminar el empleado");
    }
}
