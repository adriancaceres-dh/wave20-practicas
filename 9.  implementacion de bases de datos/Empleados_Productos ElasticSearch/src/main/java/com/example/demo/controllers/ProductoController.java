package com.example.demo.controllers;

import com.example.demo.domain.Producto;
import com.example.demo.services.ProductoService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/productos")
    public Producto save (@RequestBody Producto producto){
        return productoService.save(producto);
    }

    @GetMapping("/productos")
    public Producto findById (@RequestParam String id){
        return productoService.findById(id);
    }
}
