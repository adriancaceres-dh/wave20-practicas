package com.bootcamp.movies.service;

import com.bootcamp.movies.dto.response.ActorFavoriteMovieResponseDto;
import com.bootcamp.movies.dto.response.ActorWithFullNameAndRatingResponseDto;
import com.bootcamp.movies.repository.ActorMovieRepository;
import com.bootcamp.movies.repository.ActorRepository;
import com.bootcamp.movies.service.interfaces.IActorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {

    private final ActorRepository actorRepo;
    private final ActorMovieRepository actorMovieRepository;
    private final ModelMapper modelMapper;


    public ActorService(ActorRepository actorRepo, ActorMovieRepository actorMovieRepository, ModelMapper modelMapper) {
        this.actorRepo = actorRepo;
        this.actorMovieRepository = actorMovieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ActorFavoriteMovieResponseDto> findAllActorsWhichFavoriteMovieIsNotNull() {
        return actorRepo.findAllByFavoriteMovieIsNotNull()
                .stream()
                .map(a -> modelMapper.map(a, ActorFavoriteMovieResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorWithFullNameAndRatingResponseDto> findAllActorsWhichRatingExceeds(Double lowerBound) {
        return actorRepo.findAllByRatingGreaterThan(lowerBound)
                .stream()
                .map(a -> modelMapper.map(a, ActorWithFullNameAndRatingResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActorWithFullNameAndRatingResponseDto> findActorsThatWorkedInMovie(Integer movieId) {
        return actorMovieRepository.findActorsThatWorkedInMovie(movieId)
                .stream()
                .map(a -> modelMapper.map(a, ActorWithFullNameAndRatingResponseDto.class))
                .collect(Collectors.toList());
    }


}
