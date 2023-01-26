package com.bootcamp.MoviesHQL.dto.response;

import com.bootcamp.MoviesHQL.model.Genre;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class MovieResponseDTO {
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    private Genre genre;
}
