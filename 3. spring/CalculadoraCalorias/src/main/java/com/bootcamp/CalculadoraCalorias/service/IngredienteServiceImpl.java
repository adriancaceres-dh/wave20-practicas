package com.bootcamp.CalculadoraCalorias.service;

import com.bootcamp.CalculadoraCalorias.model.Ingrediente;
import com.bootcamp.CalculadoraCalorias.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteServiceImpl implements IngredienteService{
    @Autowired
    private IngredienteRepository ingredienteRepository;
    public List<Ingrediente> getIngredientes(){
        return ingredienteRepository.getIngredientes();
    }

}
