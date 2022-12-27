package com.bootcamp.calories.service;

import com.bootcamp.calories.dto.InfoDTO;
import com.bootcamp.calories.dto.IngredientDTO;
import com.bootcamp.calories.dto.RequestDTO;

public interface IMenuRepository {
    InfoDTO infoFood(RequestDTO request);
}
