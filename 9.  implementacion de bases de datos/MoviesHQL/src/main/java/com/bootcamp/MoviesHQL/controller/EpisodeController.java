package com.bootcamp.MoviesHQL.controller;

import com.bootcamp.MoviesHQL.service.IEpisodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episode")
public class EpisodeController {

    private final IEpisodeService episodeService;

    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/byActor")
    ResponseEntity<?> findEpisodeByActor(@RequestParam String firstName, @RequestParam String lastName){
        return ResponseEntity.ok(episodeService.findEpisodeByActor(firstName, lastName));
    }
}
