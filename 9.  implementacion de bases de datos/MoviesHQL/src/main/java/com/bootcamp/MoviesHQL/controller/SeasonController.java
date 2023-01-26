package com.bootcamp.MoviesHQL.controller;

import com.bootcamp.MoviesHQL.service.ISeasonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/season")
public class SeasonController {
    private final ISeasonService seasonService;

    public SeasonController(ISeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @GetMapping("/serieBySeasonNumber")
    public ResponseEntity<?> findSerieBySeasonNumber(@RequestParam Integer seasonNumber){
        return ResponseEntity.ok(seasonService.findSerieBySeasonNumber(seasonNumber));
    }
}
