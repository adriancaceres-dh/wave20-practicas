package com.bootcamp.movies.service.impl;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.entity.Actor;
import com.bootcamp.movies.repository.IActorMovieRepository;
import com.bootcamp.movies.repository.IActorRepository;
import com.bootcamp.movies.service.interfaces.IActorService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;

@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    private IActorRepository actorRepository;

    @Autowired
    private IActorMovieRepository actorMovieRepository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<ActorDTO> getActorsWithFavortiteMovie() {
         List<Actor> actors =  actorRepository.findByFavoriteMovieNotNull();
         return actors.stream().map(a -> mapper.map(a, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorsWhooseRatingIsGreaterThan(Double rating) {
        List<Actor> actors = actorRepository.findByRatingGreaterThan(rating);
        return actors.stream().map(a -> mapper.map(a, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorsOfMovie(Integer movieId) {
        List<Actor> actors = actorMovieRepository.findActorsOfTheMovie(movieId);
        return actors.stream().map(a -> mapper.map(a, ActorDTO.class)).collect(Collectors.toList());
    }
}
