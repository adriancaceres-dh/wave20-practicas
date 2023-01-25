package com.bootcamp.movies_hql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ActorDTO {

    private Integer id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private Double rating;
    @JsonProperty("created_at")
    private LocalDate createdAt;
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
    @JsonProperty("favorite_movie")
    private MovieDTO favoriteMovie;
}
