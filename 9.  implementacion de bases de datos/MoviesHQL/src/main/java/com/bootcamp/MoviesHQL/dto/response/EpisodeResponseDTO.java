package com.bootcamp.MoviesHQL.dto.response;

import com.bootcamp.MoviesHQL.model.Season;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class EpisodeResponseDTO {
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
    private Season season;
}
