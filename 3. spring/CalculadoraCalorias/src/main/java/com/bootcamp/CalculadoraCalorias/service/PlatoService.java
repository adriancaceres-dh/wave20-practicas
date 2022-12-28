package com.bootcamp.CalculadoraCalorias.service;

import com.bootcamp.CalculadoraCalorias.dto.IngredienteDTO;
import com.bootcamp.CalculadoraCalorias.dto.PlatoDTO;

import java.util.List;
import java.util.Set;

public interface PlatoService {

    public Double calcularCaloriasPorPlato (PlatoDTO platoDTO);
    public Set<String> informacionPlato (PlatoDTO platoDTO);
    public List<IngredienteDTO> masCalorico(PlatoDTO platoDTO);
    public List<String> completo (List<PlatoDTO> listaPlatos);
}
