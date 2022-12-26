package com.example.ejerciciocalorias.service;

import com.example.ejerciciocalorias.dao.IIngredientesRepository;
import com.example.ejerciciocalorias.dto.IngredienteDto;
import com.example.ejerciciocalorias.dto.PlatoDto;
import org.springframework.stereotype.Service;

@Service
public class CaloriasService {
  private IIngredientesRepository caloriasRepository;

  public CaloriasService(IIngredientesRepository caloriasRepository) {
    this.caloriasRepository = caloriasRepository;
  }

  public int getCaloriasPlato(PlatoDto platoDto) {
    int caloriasPorCienGramos = 0;
    for (IngredienteDto ingrediente : platoDto.getIngredientes()) {
      caloriasPorCienGramos += ingrediente.getCalorias()*ingrediente.getPeso();
    }
    return caloriasPorCienGramos*platoDto.getPeso()/100;
  }

  public IngredienteDto getIngredienteMasCalorico(PlatoDto platoDto) {
    IngredienteDto ingredienteMasCalorico = platoDto.getIngredientes().get(0);
    for (IngredienteDto ingrediente : platoDto.getIngredientes()) {
      if(ingrediente.getCalorias()* ingrediente.getPeso() > ingredienteMasCalorico.getCalorias()* ingredienteMasCalorico.getPeso()){
        ingredienteMasCalorico = ingrediente;
      }
    }
    return ingredienteMasCalorico;
  }





}
