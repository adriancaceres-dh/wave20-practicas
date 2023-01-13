package com.calculadoracalorias.CalculadoraCalorias.services;


import com.calculadoracalorias.CalculadoraCalorias.dto.FoodDto;
import com.calculadoracalorias.CalculadoraCalorias.repositories.CalculatorRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private CalculatorRepositoryImp calculatorRepositoryImp;


    public List<FoodDto> findAllFood(){
        return calculatorRepositoryImp.findAllFood();
    }
}
