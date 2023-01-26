package com.example.Practica.HQL.controller;

import com.example.Practica.HQL.model.Episode;
import com.example.Practica.HQL.service.interfaces.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    @Autowired
    IEpisodeService iEpisodeService;

    @GetMapping("")
    public ResponseEntity<List<Episode>> findAll(@RequestParam(required = false) String actorName){
        return ResponseEntity.ok(iEpisodeService.findAll(actorName));
    }
}
