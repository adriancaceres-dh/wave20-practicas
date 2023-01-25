package com.bootcamp.movies_api.service;

import com.bootcamp.movies_api.dto.response.ActorResponseDTO;
import com.bootcamp.movies_api.entity.Actor;
import com.bootcamp.movies_api.repo.IActorRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {
    @Autowired
    IActorRepo repo;
    ObjectMapper mapper;

    public ActorService(){
        mapper = new ObjectMapper();
    }

    public List<ActorResponseDTO> getActorsWithFavMovies(){
        List<Actor> actorsListFromRepo = repo.findByFavMovieIsNotNull();
        List<ActorResponseDTO> responseList = new ArrayList<>();
        actorsListFromRepo.forEach(auxActor -> {
            if(auxActor.getFavMovie() != null) {
                responseList.add(new ActorResponseDTO(
                        auxActor.getFirst_name(),
                        auxActor.getLast_name(),
                        auxActor.getRating(),
                        auxActor.getFavMovie().getTitle()));
            }
        });
        return responseList;
    }

}
