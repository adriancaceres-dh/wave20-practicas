package com.bootcamp.appcalorias.controller;

import com.bootcamp.appcalorias.dto.PlateDto;
import com.bootcamp.appcalorias.model.Ingredient;
import com.bootcamp.appcalorias.model.Plate;
import com.bootcamp.appcalorias.service.IPlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Restaurant {
    @Autowired
    IPlateService plateService;
    @GetMapping("/plate/{plateName}")
    public PlateDto platStats(@PathVariable String plateName){
        return  plateService.calculatePlate(plateName);
    }

    @GetMapping("/ingredient/{index}")
    public Ingredient randomIngredient(@PathVariable int index){
        return  plateService.getIngredient(index);
    }

    @PostMapping("/plates")
    public List<PlateDto> platesInfo(@RequestBody List<Plate> plates){
        return  plateService.calculatePlates(plates);
    }
    /*
    Al no tener una base de datos se deben usar los datos de prueba para que pueda encontrar los datos
    [
    {
        "name": "Sudado",
        "ingredients": [
            {
                "name": "Atún fresco",
                "calories": 225
            },
            {
                "name": "Papas cocidas",
                "calories": 86
            }
        ]
    },
    {
        "name": "Ajiaco",
        "ingredients": [
            {
                "name": "Pollo, Muslo",
                "calories": 186
            },
            {
                "name": "Mantequilla",
                "calories": 752
            }
        ]
    },
    {
        "name": "Sancocho",
        "ingredients": [
            {
                "name": "Merluza",
                "calories": 86
            },
            {
                "name": "Bacalao seco",
                "calories": 322
            }
        ]
    }
]
    */
}
