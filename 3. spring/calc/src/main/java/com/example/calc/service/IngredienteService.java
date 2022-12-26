package com.example.calc.service;

import com.example.calc.model.Ingrediente;
import com.example.calc.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService implements IIngredienteService{

    @Autowired
    private IIngredienteRepository repo;

    public int calcularCalorias(String ingrediente, int peso){
        for(Ingrediente i: repo.getIngredientes()) if(i.getName().equals(ingrediente)) return i.getCalories()*peso;
        return 0;
    }

}
