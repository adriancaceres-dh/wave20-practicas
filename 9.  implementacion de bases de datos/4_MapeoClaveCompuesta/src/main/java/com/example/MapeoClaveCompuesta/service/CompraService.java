package com.example.MapeoClaveCompuesta.service;

import com.example.MapeoClaveCompuesta.dto.CompraRequestDTO;
import com.example.MapeoClaveCompuesta.dto.CompraResponseDTO;
import com.example.MapeoClaveCompuesta.model.Compra;
import com.example.MapeoClaveCompuesta.repository.ICompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService implements ICompraService{

    @Autowired
    ICompraRepository iCompraRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public CompraResponseDTO createCompra(CompraRequestDTO compraRequestDTO){
        Compra compra = iCompraRepository.save(modelMapper.map(compraRequestDTO, Compra.class));
        return modelMapper.map(compra, CompraResponseDTO.class);
    }
}
