package com.example.Practica.HQL.service;

import com.example.Practica.HQL.model.Actor;
import com.example.Practica.HQL.repository.IActorRepository;
import com.example.Practica.HQL.service.interfaces.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    @Autowired
    IActorRepository iActorRepository;

    //Tengo que investigar si existe mejor manera en vez de anidar tantos if.
    public List<Actor> findAll(Boolean favMovie, Double rating, Integer movieId){
        if (favMovie && rating!=null && movieId!=null)
            return iActorRepository.findByFavoriteMovieIsNotNullAndRatingGreaterThanAndMovieLike(rating,movieId);
        else if(favMovie && rating!=null)
            return iActorRepository.findByFavoriteMovieIsNotNullAndRatingGreaterThan(rating);
        else if(favMovie && movieId!=null)
            return iActorRepository.findByFavoriteMovieIsNotNullAndMovieLike(movieId);
        else if(rating!=null && movieId!=null)
            return iActorRepository.findByRatingGreaterThanAndMovieLike(rating,movieId);
        else if (favMovie)
            return iActorRepository.findByFavoriteMovieIsNotNull();
        else if (rating!=null)
            return iActorRepository.findByRatingGreaterThan(rating);
        else if(movieId!=null)
            return iActorRepository.findByMovieLike(movieId);
        else
            return iActorRepository.findAll();
    }
}
