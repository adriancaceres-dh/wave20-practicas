package com.example.Practica.HQL.controller;

import com.example.Practica.HQL.model.Serie;
import com.example.Practica.HQL.service.interfaces.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    ISerieService iSerieService;

    @GetMapping("")
    public ResponseEntity<List<Serie>> findAll(@RequestParam(required = false) Integer cantSeasons){
        return ResponseEntity.ok(iSerieService.findAll(cantSeasons));
    }
}
