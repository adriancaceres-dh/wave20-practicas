package com.example.demo.services;

import com.example.demo.domain.Producto;
import com.example.demo.elasticrepositories.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{
    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto findById(String id) {
        return productoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se encontro el producto")
        );
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }
}
