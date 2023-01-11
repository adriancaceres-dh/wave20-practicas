package com.bootcamp.ejercicio_deportistas.services.interfaces;

import com.bootcamp.ejercicio_deportistas.dtos.DeporteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDeporteService
{
    public List<DeporteDTO> listarDesportes();
    public int consultarDeporte(String nombre);
}
