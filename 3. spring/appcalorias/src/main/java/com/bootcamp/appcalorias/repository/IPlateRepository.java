package com.bootcamp.appcalorias.repository;

import com.bootcamp.appcalorias.model.Plate;

public interface IPlateRepository {

    public int calculateCalories(String plateName);
    public Plate getPlate(String plateName);
}
