package com.example.demo.services;

import com.example.demo.domain.Producto;

public interface ProductoService {

    Producto findById (String id);
    Producto save (Producto producto);
}
