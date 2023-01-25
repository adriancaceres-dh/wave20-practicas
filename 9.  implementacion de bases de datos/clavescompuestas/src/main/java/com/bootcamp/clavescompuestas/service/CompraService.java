package com.bootcamp.clavescompuestas.service;

import com.bootcamp.clavescompuestas.model.Compra;
import com.bootcamp.clavescompuestas.model.CompraKey;
import com.bootcamp.clavescompuestas.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {
    CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public List<Compra> buscarComprasPorIdCliente(Integer id) {
        return compraRepository.findByClienteIdEquals(id);
    }

    public Compra buscarCompra(CompraKey key) {
        return compraRepository.findById(key).orElseThrow(() -> {
            throw new RuntimeException("No se encontró cliente por ese ID");
        });
    }
}
