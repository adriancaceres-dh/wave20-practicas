package com.bootcamp.movies_hql.service;

import com.bootcamp.movies_hql.dto.response.ActorDTO;
import com.bootcamp.movies_hql.entity.Actor;
import com.bootcamp.movies_hql.exception.NotFoundException;
import com.bootcamp.movies_hql.repository.IActorRepository;
import com.bootcamp.movies_hql.service.interfaces.IActorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {

    @Autowired
    IActorRepository actorRepository;

    private final ModelMapper mapper = new ModelMapper();

    public ActorService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true);
    }

    @Override
    public ActorDTO saveEntity(ActorDTO crudDTO) {
        var entity = mapper.map(crudDTO, Actor.class);

        entity = actorRepository.save(entity);

        return mapper.map(entity, ActorDTO.class);
    }

    @Override
    public ActorDTO getEntityById(Long id) {
        if (!actorRepository.existsById(id)) {
            throw new NotFoundException("Ese actor no existe.");
        }
        Actor actor = actorRepository.findById(id).get();
        return mapper.map(actor, ActorDTO.class);
    }

    @Override
    public List<ActorDTO> getAllEntities() {
        return actorRepository.findAll().stream().map(m -> mapper.map(m, ActorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteEntity(Long id) {
        if (!actorRepository.existsById(id)) {
            throw new NotFoundException("Esa película no existe.");
        }
        Actor actor = actorRepository.findById(id).get();
        String name = actor.getFirstName() + " " + actor.getLastName();
        actorRepository.deleteById(id);
        return "Se ha eliminado el actor: " + name;
    }

    @Override
    public List<ActorDTO> getActorsWithFavoriteMovie() {
        return actorRepository.findActorByFirstNameNotNull().stream().map(m -> mapper.map(m, ActorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorsWithRatingGreaterThan(double rating) {
        return actorRepository.findActorByRatingGreaterThan(rating).stream().map(m -> mapper.map(m, ActorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getActorsWithMovieNameEquals(String title) {
        return actorRepository.findActorByMovieEquals(title).stream().map(m -> mapper.map(m, ActorDTO.class))
                .collect(Collectors.toList());
    }
}
