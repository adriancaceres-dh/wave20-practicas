package com.bootcamp.calculadoracalorias.service;

import com.bootcamp.calculadoracalorias.model.Dish;
import com.bootcamp.calculadoracalorias.repository.FoodRepository;
import com.bootcamp.calculadoracalorias.service.interfaces.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService implements IFoodService {

    @Autowired
    FoodRepository foodRepository;


}
