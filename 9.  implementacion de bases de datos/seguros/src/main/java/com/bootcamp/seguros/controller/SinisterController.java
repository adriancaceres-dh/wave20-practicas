package com.bootcamp.seguros.controller;

import com.bootcamp.seguros.dto.SinisterDTO;
import com.bootcamp.seguros.service.ISinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SinisterController {
    @Autowired
    private ISinisterService sinisterService;
    @PostMapping("/createSinister/{id}")
    public ResponseEntity<?> create(@RequestBody SinisterDTO sinisterDTO, @PathVariable Long id){
        return new ResponseEntity<>(sinisterService.createSinister(sinisterDTO,id), HttpStatus.ACCEPTED);
    }
}
