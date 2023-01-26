package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.dto.response.EpisodeDTO;
import com.bootcamp.movies_hql.dto.response.MovieDTO;
import com.bootcamp.movies_hql.service.interfaces.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {

    @Autowired
    IEpisodeService episodeService;

    @GetMapping("")
    public ResponseEntity<List<EpisodeDTO>> getEpisodes(){
        return ResponseEntity.ok(episodeService.getAllEntities());
    }

    @PostMapping("/new")
    public ResponseEntity<EpisodeDTO> addEpisode(@RequestBody EpisodeDTO episodeDTO){
        return ResponseEntity.ok(episodeService.saveEntity(episodeDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<EpisodeDTO> updateEpisode(@RequestBody EpisodeDTO episodeDTO){
        return ResponseEntity.ok(episodeService.saveEntity(episodeDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEpisode(@PathVariable Long id){
        return ResponseEntity.ok(episodeService.deleteEntity(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpisodeDTO> getEpisodesById(@PathVariable Long id){
        return ResponseEntity.ok(episodeService.getEntityById(id));
    }

    // Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @GetMapping("/nameEqualsThan/{name}")
    public ResponseEntity<List<EpisodeDTO>> getEpisodesWithActorNameEqualsThan(@PathVariable String name){
        return ResponseEntity.ok(episodeService.getEpisodesWithActorNameEqualsThan(name));
    }
}
