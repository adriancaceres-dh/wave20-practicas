package com.bootcamp.Employees.exercise.controller;

import com.bootcamp.Employees.exercise.dto.EmployeeRequestDTO;
import com.bootcamp.Employees.exercise.dto.ProductRequestDTO;
import com.bootcamp.Employees.exercise.model.Employee;
import com.bootcamp.Employees.exercise.model.Product;
import com.bootcamp.Employees.exercise.service.intefaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @PostMapping("")
    public ResponseEntity<Boolean> newProduct(@RequestBody ProductRequestDTO productRequestDTO){
        return ResponseEntity.ok(iProductService.newProduct(productRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateProduct(@RequestBody ProductRequestDTO productRequestDTO,
                                                  @PathVariable Integer id){
        return ResponseEntity.ok(iProductService.updateProduct(productRequestDTO,id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> readProduct(@PathVariable Integer id){
        return ResponseEntity.ok(iProductService.readProduct(id));
    }
}
