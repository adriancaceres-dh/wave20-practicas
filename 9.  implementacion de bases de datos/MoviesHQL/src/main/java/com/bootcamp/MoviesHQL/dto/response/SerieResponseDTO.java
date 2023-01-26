package com.bootcamp.MoviesHQL.dto.response;

import com.bootcamp.MoviesHQL.model.Genre;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class SerieResponseDTO {
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private Genre genre;
}
