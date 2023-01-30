package com.hql.movies.controller;

import com.hql.movies.model.Serie;
import com.hql.movies.service.interfaces.ISerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {


    ISerieService serieService;
    public SerieController(ISerieService serieService) {
        this.serieService = serieService;
    }
    @GetMapping("/moreSeasonsThan{quantitySeason}")
    public ResponseEntity<List<Serie>> getSeriesWithMoreSeasonsThan(@RequestParam Integer quantitySeason){
        return new ResponseEntity<>(serieService.getSeriesWithMoreSeasonsThan(quantitySeason), HttpStatus.OK);
    }
}
