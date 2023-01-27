package com.bootcamp.Employees.exercise.controller;

import com.bootcamp.Employees.exercise.dto.EmployeeRequestDTO;
import com.bootcamp.Employees.exercise.model.Employee;
import com.bootcamp.Employees.exercise.service.intefaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping("")
    public ResponseEntity<Boolean> newEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return ResponseEntity.ok(iEmployeeService.newEmployee(employeeRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO,
                                                  @PathVariable Integer id){
        return ResponseEntity.ok(iEmployeeService.updateEmployee(employeeRequestDTO,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> readEmployee(@PathVariable Integer id){
        return ResponseEntity.ok(iEmployeeService.readEmployee(id));
    }
}
