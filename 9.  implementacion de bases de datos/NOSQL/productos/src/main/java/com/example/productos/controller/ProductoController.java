package com.example.productos.controller;

import com.example.productos.dto.request.ProductoRequestDTO;
import com.example.productos.dto.response.ProductoResponseDTO;
import com.example.productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @PostMapping("/producto")
    public ResponseEntity<ProductoResponseDTO> saveProducto(@RequestBody ProductoRequestDTO productoRequestDTO){
        return new ResponseEntity<>(productoService.saveProducto(productoRequestDTO), HttpStatus.CREATED);
    }
    @PutMapping("/producto/{id}")
    public ResponseEntity<ProductoResponseDTO> updateProducto(@PathVariable String id, @RequestBody ProductoRequestDTO productoRequestDTO){
        return new ResponseEntity<>(productoService.updateProducto(id, productoRequestDTO), HttpStatus.OK);
    }
}
