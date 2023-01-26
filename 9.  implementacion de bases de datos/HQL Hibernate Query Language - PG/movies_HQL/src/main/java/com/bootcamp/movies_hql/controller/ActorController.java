package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.dto.response.ActorDTO;
import com.bootcamp.movies_hql.dto.response.MovieDTO;
import com.bootcamp.movies_hql.service.interfaces.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {


    @Autowired
    IActorService actorService;

    @GetMapping("")
    public ResponseEntity<List<ActorDTO>> getActors() {
        return ResponseEntity.ok(actorService.getAllEntities());
    }

    @PostMapping("/new")
    public ResponseEntity<ActorDTO> addActor(@RequestBody ActorDTO actorDTO) {
        return ResponseEntity.ok(actorService.saveEntity(actorDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<ActorDTO> updateActor(@RequestBody ActorDTO actorDTO) {
        return ResponseEntity.ok(actorService.saveEntity(actorDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable Long id) {
        return ResponseEntity.ok(actorService.deleteEntity(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> getActorById(@PathVariable Long id) {
        return ResponseEntity.ok(actorService.getEntityById(id));
    }

    // Listar todos los actores que tengan declarada una película favorita.
    @GetMapping("/withFavoriteMovie")
    public ResponseEntity<List<ActorDTO>> getActorsWithFavoriteMovie() {
        return ResponseEntity.ok(actorService.getActorsWithFavoriteMovie());
    }

    // Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/ratingGreaterThan/{rating}")
    public ResponseEntity<List<ActorDTO>> getActorsWithRatingGreaterThan(@PathVariable double rating) {
        return ResponseEntity.ok(actorService.getActorsWithRatingGreaterThan(rating));
    }

    // Listar todos los actores que trabajan en la <película recibida por parámetro>
    @GetMapping("/movieEqualsThan/{title}")
    public ResponseEntity<List<ActorDTO>> getActorsWithMovieNameEquals(@PathVariable String title) {
        return ResponseEntity.ok(actorService.getActorsWithMovieNameEquals(title));
    }

}
