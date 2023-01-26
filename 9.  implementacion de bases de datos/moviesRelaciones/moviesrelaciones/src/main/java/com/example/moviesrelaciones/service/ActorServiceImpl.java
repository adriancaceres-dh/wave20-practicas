package com.example.moviesrelaciones.service;

import com.example.moviesrelaciones.dto.ActorDTO;
import com.example.moviesrelaciones.dto.MovieDTO;
import com.example.moviesrelaciones.entity.Actor;
import com.example.moviesrelaciones.entity.Movie;
import com.example.moviesrelaciones.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ICRUDService<ActorDTO>{

    ModelMapper mapper = new ModelMapper();
    @Autowired
    IActorRepository actorRepository;
    @Override
    public List<ActorDTO> getAllEntities() {
        return actorRepository.findAll().stream()
                .map(e-> new ActorDTO(
                        e.getId(),
                        e.getCreatedAt(),
                        e.getUpdatedAt(),
                        e.getFirst_name(),
                        e.getLast_name(),
                        e.getRating(),
                        e.getActorMovies().stream().map(p->mapper.map(p.getMovie(), MovieDTO.class)).collect(Collectors.toList())

                        ))
                .collect(Collectors.toList());
    }
}
