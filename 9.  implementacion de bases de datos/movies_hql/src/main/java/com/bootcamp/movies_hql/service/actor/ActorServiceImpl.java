package com.bootcamp.movies_hql.service.actor;

import com.bootcamp.movies_hql.dto.ActorDTO;
import com.bootcamp.movies_hql.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements IActorService {

    private final IActorRepository actorRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ActorServiceImpl(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public Set<ActorDTO> getActorsByFavoriteMovieNotNull() {
        return actorRepository.findByFavoriteMovieNotNull().stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public Set<ActorDTO> getActorsByRatingGreaterThan(Double rating) {
        return actorRepository.findByRatingGreaterThan(rating).stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class)).collect(Collectors.toSet());
    }

    @Override
    public Set<ActorDTO> getActorsByMovieWorkedIn(Integer movieId) {
        return actorRepository.findByMovieWorkedIn(movieId).stream()
                .map(actor -> modelMapper.map(actor, ActorDTO.class)).collect(Collectors.toSet());
    }
}
