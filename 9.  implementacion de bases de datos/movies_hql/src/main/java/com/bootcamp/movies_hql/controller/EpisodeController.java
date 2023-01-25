package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.dto.EpisodeDTO;
import com.bootcamp.movies_hql.service.episode.IEpisodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    private final IEpisodeService episodeService;

    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("actor/{actorId}")
    public ResponseEntity<Set<EpisodeDTO>> getEpisodesByActorId(@PathVariable Integer actorId) {
        return ResponseEntity.status(HttpStatus.OK).body(episodeService.getEpisodesByActorId(actorId));
    }
}
