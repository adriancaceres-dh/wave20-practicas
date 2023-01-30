package com.bootcamp.MiniSeries.controller;

import com.bootcamp.MiniSeries.dto.MessageDTO;
import com.bootcamp.MiniSeries.dto.MiniSerieDTO;
import com.bootcamp.MiniSeries.service.interfaces.IMiniSeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/miniseries")
public class MiniSerieController {

    private final IMiniSeriesService miniSeriesService;

    public MiniSerieController(IMiniSeriesService miniSeriesService) {
        this.miniSeriesService = miniSeriesService;
    }


    @PostMapping("/")
    public ResponseEntity<MiniSerieDTO> newMiniSerie(@RequestBody MiniSerieDTO miniSerie){
        return new ResponseEntity<>(miniSeriesService.saveEntity(miniSerie), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiniSerieDTO> getMiniSerie(@PathVariable Long id){
        return new ResponseEntity<>(miniSeriesService.getEntityById(id), HttpStatus.OK);

    }
    @GetMapping("/")
    public ResponseEntity<List<MiniSerieDTO>> getAll(){
        return new ResponseEntity<>(miniSeriesService.getAllEntities(), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<MessageDTO> deleteMiniSerie(@PathVariable Long id){
        return new ResponseEntity<>(miniSeriesService.deleteEntity(id), HttpStatus.OK);
    }

}
