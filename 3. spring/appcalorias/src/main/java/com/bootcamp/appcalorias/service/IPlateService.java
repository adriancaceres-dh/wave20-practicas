package com.bootcamp.appcalorias.service;

import com.bootcamp.appcalorias.dto.PlateDto;
import com.bootcamp.appcalorias.model.Ingredient;
import com.bootcamp.appcalorias.model.Plate;

import java.util.List;

public interface IPlateService {
    public PlateDto calculatePlate(String plateName);
    public List<PlateDto> calculatePlates(List<Plate> plateList);

    public Ingredient getIngredient(int index);
}
