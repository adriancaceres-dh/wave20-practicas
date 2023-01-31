package com.bootcamp.movies.dto;

import com.bootcamp.movies.entity.Movie;
import com.bootcamp.movies.entity.intermediate.ActorEpisode;
import com.bootcamp.movies.entity.intermediate.ActorMovie;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {

    private Integer id;

    private String firstName;
    private String lastName;
    private Double rating;

    private MovieDTO favoriteMovie;

}
