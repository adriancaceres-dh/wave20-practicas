package com.bootcamp.ejercicio_calorias.controller;


import com.bootcamp.ejercicio_calorias.dto.DishDTO;
import com.bootcamp.ejercicio_calorias.model.Dish;
import com.bootcamp.ejercicio_calorias.repository.IDishRepository;
import com.bootcamp.ejercicio_calorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.events.EntityReference;
import java.util.List;

@RestController
public class DishController
{
    @Autowired
    private IDishService dishService;


    @GetMapping(path = "/{name}")
    public ResponseEntity<List<DishDTO>>  getDishes(@PathVariable String name){
                return ResponseEntity.ok(dishService.getByName(name));
    }

}
