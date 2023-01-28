package com.example.peliculas.controller;

import com.example.peliculas.dto.ActorDto;
import com.example.peliculas.dto.EpisodeDto;
import com.example.peliculas.dto.MovieDto;
import com.example.peliculas.dto.SerieDto;
import com.example.peliculas.entity.Actor;
import com.example.peliculas.entity.Episode;
import com.example.peliculas.entity.Serie;
import com.example.peliculas.service.IActorService;
import com.example.peliculas.service.IEspisodeService;
import com.example.peliculas.service.IMovieService;
import com.example.peliculas.service.ISerieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    ISerieService serieService;

    @Autowired
    IActorService actorService;

    @Autowired
    IMovieService movieService;

    @Autowired
    IEspisodeService espisodeService;



    @GetMapping("/list/Actores/favoritemovie")
    public ResponseEntity<List<ActorDto>> listActorsByFavoriteMovie(){

        return new ResponseEntity<>(actorService.findByMovieNotNull(), HttpStatus.OK);
    }

    @GetMapping("/list/Actores/byrating")
    public ResponseEntity<List<ActorDto>> listActorsByRating(@RequestParam Double rating){

        return new ResponseEntity<>(actorService.findByating(rating), HttpStatus.OK);
    }

    @GetMapping("/list/Actores/bymovie")
    public ResponseEntity<List<ActorDto>> listActorsByRating(@RequestParam String movie){

        return new ResponseEntity<>(actorService.selectActorsByMovie(movie), HttpStatus.OK);
    }

    @GetMapping("/list/Movies/bygenre")
    public ResponseEntity<List<MovieDto>> listMoviesByGenre(@RequestParam String genre){

        return new ResponseEntity<>(movieService.findMoviesByGenre(genre), HttpStatus.OK);
    }

    @GetMapping("/list/Series/byseasonsnumber")
    public ResponseEntity<List<SerieDto>> listSeriesBySeasonsNumber(@RequestParam Integer number){

        return new ResponseEntity<>(serieService.findAllBySeasonsNumber(number), HttpStatus.OK);
    }

    @GetMapping("/list/Movies/byactors")
    public ResponseEntity<List<MovieDto>> listSeriesBySeasonsNumber(@RequestParam Double rating){

        return new ResponseEntity<>(movieService.findByMovie(rating), HttpStatus.OK);
    }


    @GetMapping("/list/Episodes/byactor")
    public ResponseEntity<List<EpisodeDto>> listEpisodesByActorName(@RequestParam String name){

        return new ResponseEntity<>(espisodeService.findEpisodesByActor(name), HttpStatus.OK);
    }

}
