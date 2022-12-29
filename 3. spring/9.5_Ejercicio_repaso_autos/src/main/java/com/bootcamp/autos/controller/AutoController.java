package com.bootcamp.autos.controller;

import com.bootcamp.autos.dto.request.AutoRequestDto;
import com.bootcamp.autos.dto.response.AutoResponseDto;
import com.bootcamp.autos.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AutoController {

    @Autowired
    IAutoService autoService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<AutoResponseDto>> getAutos() {
        return new ResponseEntity<>(autoService.getAutos(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<String> agregar(@RequestBody AutoRequestDto autoRequestDto) {
        return new ResponseEntity<>(autoService.agregarAuto(autoRequestDto),HttpStatus.CREATED);
    }
}
