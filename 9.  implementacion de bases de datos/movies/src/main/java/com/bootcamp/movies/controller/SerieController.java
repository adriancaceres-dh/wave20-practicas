package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.SerieDto;
import com.bootcamp.movies.service.interfaces.ISerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    private final ISerieService serieService;

    public SerieController(ISerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/with-more-seasons-that/{seasonsAmount}")
    public ResponseEntity<List<SerieDto>> getSeriesWithMoreSeasonsThat(@PathVariable Integer seasonsAmount) {
        return ResponseEntity.ok(serieService.findAllSeriesWhenHaveMoreSeasonsThan(seasonsAmount));
    }
}
