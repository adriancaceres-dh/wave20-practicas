package com.bootcamp.movies_hql.controller;


import com.bootcamp.movies_hql.dto.response.SerieDTO;
import com.bootcamp.movies_hql.service.interfaces.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    @Autowired
    ISerieService serieService;

    @GetMapping("")
    public ResponseEntity<List<SerieDTO>> getSeries(){
        return ResponseEntity.ok(serieService.getAllEntities());
    }

    @PostMapping("/new")
    public ResponseEntity<SerieDTO> addSerie(@RequestBody SerieDTO SerieDTO){
        return ResponseEntity.ok(serieService.saveEntity(SerieDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<SerieDTO> updateSerie(@RequestBody SerieDTO SerieDTO){
        return ResponseEntity.ok(serieService.saveEntity(SerieDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSerie(@PathVariable Long id){
        return ResponseEntity.ok(serieService.deleteEntity(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieDTO> getSeriesById(@PathVariable Long id){
        return ResponseEntity.ok(serieService.getEntityById(id));
    }

    // Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @GetMapping("/NumerSeasonGreaterEqualsThan/{cant_season}")
    public ResponseEntity<List<SerieDTO>> getSeriesWithNumberSeasonHigherThan(@PathVariable int cant_season){
        return ResponseEntity.ok(serieService.getSeriesWithNumberSeasonHigherThan(cant_season));
    }
}
