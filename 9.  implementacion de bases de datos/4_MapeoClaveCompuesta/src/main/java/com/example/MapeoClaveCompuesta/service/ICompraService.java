package com.example.MapeoClaveCompuesta.service;

import com.example.MapeoClaveCompuesta.dto.CompraRequestDTO;
import com.example.MapeoClaveCompuesta.dto.CompraResponseDTO;

public interface ICompraService {

    public CompraResponseDTO createCompra(CompraRequestDTO compraRequestDTO);
}
