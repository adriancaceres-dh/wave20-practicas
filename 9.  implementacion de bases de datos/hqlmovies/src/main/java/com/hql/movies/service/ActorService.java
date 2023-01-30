package com.hql.movies.service;

import com.hql.movies.dto.MessageDTO;
import com.hql.movies.dto.response.ActorDto;
import com.hql.movies.dto.response.ActorListedDTO;
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

    public ActorListedDTO getActorsWithLikedMovies(){
        List<Actor> actorsWithLikedMovies = actorRepository.findAll().stream().filter(actor -> !Objects.isNull(actor.getFavoriteMovie())).collect(Collectors.toList());
        List<ActorDto> actorDtoWithLikedMovies = actorsWithLikedMovies.stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .collect(Collectors.toList());
        return ActorListedDTO.builder().actorDtoList(actorDtoWithLikedMovies).build();
    }

    @Override
    public ActorListedDTO getActorsByRating(Double rating) {
        List<Actor> actorsWithLikedMovies = actorRepository.findAll().stream().filter(actor -> actor.getRating() >= rating).collect(Collectors.toList());
        List<ActorDto> actorsByRating = actorsWithLikedMovies.stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .collect(Collectors.toList());
        return ActorListedDTO.builder().actorDtoList(actorsByRating).build();
    }

    public ActorListedDTO getActorsByRatingHQL(Double rating) {
        List<Actor> actorsWithLikedMovies = actorRepository.findActorsByRatingGreaterThanEqual(rating);
        List<ActorDto> actorsByRating = actorsWithLikedMovies.stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .collect(Collectors.toList());
        return ActorListedDTO.builder().actorDtoList(actorsByRating).build();
    }
}
