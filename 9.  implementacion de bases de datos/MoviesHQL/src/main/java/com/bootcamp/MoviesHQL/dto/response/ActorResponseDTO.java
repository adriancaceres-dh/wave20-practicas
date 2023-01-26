package com.bootcamp.MoviesHQL.dto.response;

import com.bootcamp.MoviesHQL.model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActorResponseDTO {
    private String firstName;
    private String lastName;
    private Double rating;
    private Movie movie;
}
