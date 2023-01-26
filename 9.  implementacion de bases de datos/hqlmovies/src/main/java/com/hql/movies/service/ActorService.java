package com.hql.movies.service;

import com.hql.movies.dto.MessageDTO;
import com.hql.movies.dto.response.ActorDto;
import com.hql.movies.dto.response.ActorsLikedMoviesDTO;
import com.hql.movies.dto.response.ActorsRatingDTO;
import com.hql.movies.model.Actor;
import com.hql.movies.repository.IActorRepository;
import com.hql.movies.service.interfaces.IActorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {
    final
    IActorRepository actorRepository;
    private ModelMapper mapper = new ModelMapper();

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor saveEntity(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor getEntityById(Integer integer) {
        return null;
    }

    @Override
    public List<Actor> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }

    public ActorsLikedMoviesDTO getActorsWithLikedMovies(){
        List<Actor> actorsWithLikedMovies = actorRepository.findAll().stream().filter(actor -> !Objects.isNull(actor.getFavoriteMovie())).collect(Collectors.toList());
        List<ActorDto> actorDtoWithLikedMovies = actorsWithLikedMovies.stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .collect(Collectors.toList());
        return ActorsLikedMoviesDTO.builder().actorsWithLikedMovies(actorDtoWithLikedMovies).build();
    }

    @Override
    public ActorsRatingDTO getActorsByRating(Double rating) {
        return null;
    }
}
