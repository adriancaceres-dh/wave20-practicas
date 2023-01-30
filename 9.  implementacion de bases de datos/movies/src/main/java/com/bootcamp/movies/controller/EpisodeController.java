package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.EpisodeDto;
import com.bootcamp.movies.service.interfaces.IEpisodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes/")
public class EpisodeController {
    private final IEpisodeService episodeService;

    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/with-actor/{actorId}")
    public ResponseEntity<List<EpisodeDto>> findAllEpisodesByActorIdAppearance(@PathVariable Integer actorId) {
        return ResponseEntity.ok(episodeService.findAllEpisodesWithActorAppearance(actorId));
    }
}
