package com.bootcamp.movies_api.service;

import com.bootcamp.movies_api.dto.response.CastMemberResponseDTO;
import com.bootcamp.movies_api.dto.response.MovieResponseDTO;
import com.bootcamp.movies_api.repo.IMovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.movies_api.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    IMovieRepo repo;


    private List<MovieResponseDTO> convertMovieToResponseDTO(List<Movie> moviesListFromRepo){
        List<MovieResponseDTO> responseList = new ArrayList<>();
        moviesListFromRepo.forEach(auxmovie -> {
            Set<CastMemberResponseDTO> castList = auxmovie.getCast().stream().map(actor-> {
                return new CastMemberResponseDTO(actor.getFirst_name(), actor.getLast_name(), actor.getRating());
            }).collect(Collectors.toSet());

            responseList.add(new MovieResponseDTO(
                auxmovie.getTitle(),
                auxmovie.getRating(),
                auxmovie.getAwards(),
                auxmovie.getRelease_date(),
                auxmovie.getLength(),
                auxmovie.getGenre()!= null? auxmovie.getGenre().getName() : "NA",
                castList
            ));
            }
        );
        return responseList;
    }

    public List<CastMemberResponseDTO> getCastMembersFromMovie(String title){
       Movie selectedMovie = repo.findByTitleIs(title);
       return selectedMovie.getCast().stream()
           .map(castMember ->
               new CastMemberResponseDTO(
                       castMember.getFirst_name(),
                       castMember.getLast_name(),
                       castMember.getRating()))
           .collect(Collectors.toList());
    }

    public List<MovieResponseDTO> getMovieWithCastRatingOver(Double rating){
        List<Movie> movieListFromBD = repo.findByCastRatingGreaterThan(rating);
        System.out.println(movieListFromBD);
        return convertMovieToResponseDTO(movieListFromBD);
    }
    public List<MovieResponseDTO> getMoviesByGenre(String genre){
        List<Movie> movieListFromBD = repo.findByGenreNameIs(genre);
        return convertMovieToResponseDTO(movieListFromBD);
    }



}
