package com.example.ejercicio_calculadora_calorias.controller;

import com.example.ejercicio_calculadora_calorias.dto.response.DishResponseDto;
import com.example.ejercicio_calculadora_calorias.service.DishService;
import com.example.ejercicio_calculadora_calorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    IDishService iDishService;
    //http://localhost:8080/platos/platillo2/323
    @GetMapping("/platos/{name}/{gramos}")
    public ResponseEntity<DishResponseDto> dishInfo(@PathVariable String name , @PathVariable double gramos){

        return  new ResponseEntity<>(iDishService.infoPlato(name,gramos), HttpStatus.OK);
    }
}
