package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.response.SimpleEpisodeDto;
import com.bootcamp.movies.service.IEpisodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
    private final IEpisodeService episodeService;

    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/actor-worked/{actorId}")
    public ResponseEntity<List<SimpleEpisodeDto>> getEpisodesWhichActorWorked(@PathVariable Integer actorId) {
        return ResponseEntity.ok().body(episodeService.getEpisodesWhichActorParticipated(actorId));
    }
}
