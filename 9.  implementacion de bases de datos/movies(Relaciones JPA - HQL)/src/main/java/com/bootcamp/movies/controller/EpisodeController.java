package com.bootcamp.movies.controller;

import com.bootcamp.movies.service.interfaces.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episode")
public class EpisodeController {

    @Autowired
    private IEpisodeService episodeService;

    @GetMapping("/actor/{actorId}")
    public ResponseEntity<?> getEpisodesOf(@PathVariable Integer actorId){
        return ResponseEntity.ok().body(episodeService.getEpisodesOf(actorId));
    }
}
