package com.example.seguros.service.interfaces;

import com.example.seguros.dto.VehiculoDto;
import com.example.seguros.dto.VehiculoSimpleDto;
import com.example.seguros.dto.templates.TemplateMarcaYPatente;
import com.example.seguros.service.interfaces.generic.ICrudService;

import java.util.List;

public interface IVehiculoService extends ICrudService<VehiculoSimpleDto,Integer> {
    public List<TemplateMarcaYPatente> getAllPatenteAndMarca();
    public List<VehiculoDto> getAllByCantRuedas();
}
