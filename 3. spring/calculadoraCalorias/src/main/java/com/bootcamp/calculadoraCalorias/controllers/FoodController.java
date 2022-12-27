package com.bootcamp.calculadoraCalorias.controllers;
import java.util.List;
import com.bootcamp.calculadoraCalorias.dto.DishDTO;
import com.bootcamp.calculadoraCalorias.dto.RequestDTO;
import com.bootcamp.calculadoraCalorias.dto.ResponseDTO;
import com.bootcamp.calculadoraCalorias.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    IFoodService foodService;

    @PostMapping (path="/dish")
    public ResponseEntity<ResponseDTO> getDishesInfo(@RequestBody List<RequestDTO> dish){
        return new ResponseEntity<>(foodService.getDishesInfo(dish),HttpStatus.OK);
    }
}
