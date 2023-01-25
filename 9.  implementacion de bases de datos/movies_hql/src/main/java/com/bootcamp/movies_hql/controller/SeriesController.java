package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.dto.SeriesDTO;
import com.bootcamp.movies_hql.service.series.ISeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private final ISeriesService seriesService;

    public SeriesController(ISeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/season_count/{count}")
    ResponseEntity<Set<SeriesDTO>> getSeriesBySeasonCountGreaterThan(@PathVariable Integer count) {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.getSeriesBySeasonCountGreaterThan(count));
    }
}
