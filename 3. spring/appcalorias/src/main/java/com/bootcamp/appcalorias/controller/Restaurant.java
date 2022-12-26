package com.bootcamp.appcalorias.controller;

import com.bootcamp.appcalorias.dto.PlateDto;
import com.bootcamp.appcalorias.model.Ingredient;
import com.bootcamp.appcalorias.service.IPlateService;
import com.bootcamp.appcalorias.service.PlateServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Restaurant {

    @Autowired
    PlateServiceImp plateService;
    @GetMapping("/plate/{plateName}")
    public PlateDto platStats(@PathVariable String plateName){
        return  plateService.calculatePlate(plateName);
    }

    @GetMapping("/ingredient/{index}")
    public Ingredient randomIngredient(@PathVariable int index){
        return  plateService.getIngredient(index);
    }
}
