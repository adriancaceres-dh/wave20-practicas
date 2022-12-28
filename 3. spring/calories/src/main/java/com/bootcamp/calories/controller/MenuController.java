package com.bootcamp.calories.controller;

import com.bootcamp.calories.dto.InfoDTO;
import com.bootcamp.calories.dto.RequestDTO;
import com.bootcamp.calories.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/info")
    public ResponseEntity<InfoDTO> infoFood(
            @RequestParam String name
            ,@RequestParam double weight){
        RequestDTO requestDTO=new RequestDTO(name,weight);
        InfoDTO infoDTO=menuService.infoFood(requestDTO);
        return ResponseEntity.ok()
                .body(infoDTO);
    }
}
