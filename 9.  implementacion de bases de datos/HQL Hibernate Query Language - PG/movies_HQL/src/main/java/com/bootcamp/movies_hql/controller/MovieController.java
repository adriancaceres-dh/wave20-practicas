package com.bootcamp.movies_hql.controller;

import com.bootcamp.movies_hql.dto.response.MovieDTO;
import com.bootcamp.movies_hql.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    IMovieService movieService;

    @GetMapping("")
    public ResponseEntity<List<MovieDTO>> getMovies(){
        return ResponseEntity.ok(movieService.getAllEntities());
    }

    @PostMapping("/new")
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(movieService.saveEntity(movieDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(movieService.saveEntity(movieDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id){
        return ResponseEntity.ok(movieService.deleteEntity(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMoviesById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getEntityById(id));
    }

    // Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/ratingGreaterThan/{rating}")
    public ResponseEntity<List<MovieDTO>> getMoviesWithRatingHigherThan(@PathVariable double rating){
        return ResponseEntity.ok(movieService.getMoviesWithRatingHigherThan(rating));
    }

    // Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @GetMapping("/genreEqualsThan/{genre}")
    public ResponseEntity<List<MovieDTO>> getMoviesWithGenreEqualsThan(@PathVariable String genre){
        return ResponseEntity.ok(movieService.getMoviesWithGenreEqualsThan(genre));
    }

}
