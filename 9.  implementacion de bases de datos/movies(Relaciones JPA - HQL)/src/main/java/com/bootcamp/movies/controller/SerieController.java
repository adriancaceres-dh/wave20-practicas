package com.bootcamp.movies.controller;

import com.bootcamp.movies.service.interfaces.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    private ISerieService serieService;

    @GetMapping("/seasons/{cant}")
    public ResponseEntity<?> get(@PathVariable Integer cant){
        return ResponseEntity.ok().body(serieService.getSeriesWhooseNumberOfSeasonsIsGreaterThan(cant));
    }
}
