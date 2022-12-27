package com.bootcamp.contadorcalorias.controller;

import com.bootcamp.contadorcalorias.dto.DishDTORequest;
import com.bootcamp.contadorcalorias.dto.DishDTOResponse;
import com.bootcamp.contadorcalorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController ("/dishes")
public class DishController {

    @Autowired
    DishService dishService;

    @GetMapping("/dishes")
    public ResponseEntity<DishDTOResponse> getDish (@RequestBody DishDTORequest dish) {
        return ResponseEntity.ok().body(dishService.getDish(dish.getName()));
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<DishDTOResponse>> getDish (@RequestBody List<DishDTORequest> dishes) {
        return ResponseEntity.ok().body(dishes.stream()
                .map(dish -> dishService.getDish(dish.getName())).collect(Collectors.toList()));
    }

}
