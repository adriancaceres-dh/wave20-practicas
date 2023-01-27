package com.bootcamp.MoviesHQL.controller;

import com.bootcamp.MoviesHQL.service.ISerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serie")
public class SerieController {
    private final ISerieService serieService;
    public SerieController(ISerieService serieService) {
        this.serieService = serieService;
    }
    @GetMapping("/bySeasonNumber")
    public ResponseEntity<?> findBySeasons (@RequestParam Integer seasonNumber){
        return ResponseEntity.ok(serieService.findBySeasonsIdGreaterThan(seasonNumber));
    }
}
