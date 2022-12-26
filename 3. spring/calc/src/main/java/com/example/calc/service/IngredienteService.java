package com.example.calc.service;

import com.example.calc.model.Ingrediente;
import com.example.calc.repository.IIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService implements IIngredienteService{

    @Autowired
    private IIngredienteRepository repo;

    public int calcularCalorias(String ingrediente, int calorias){
        /*Integer aRetornar = repo.getIngredientes().stream().filter(i -> i.getNombre().equals(ingrediente))
                .findFirst().get().getCalorias();
        if(aRetornar == null) return 0;
        else return calorias * aRetornar;*/
        //return repo.getIngredientes().stream().filter(i -> i.getNombre().equals(ingrediente)).findFirst().get().getCalorias();
        for(Ingrediente i: repo.getIngredientes()) if(i.getName().equals(ingrediente)) return i.getCalories();
        return 0;
    }

}
