package com.bootcamp.movies_hql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MovieDTO {

    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    private Integer length;
    @JsonProperty("created_at")
    private LocalDate createdAt;
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
    private GenreDTO genre;
}
