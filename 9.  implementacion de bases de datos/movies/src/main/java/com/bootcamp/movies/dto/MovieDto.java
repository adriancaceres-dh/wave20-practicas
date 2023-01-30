package com.bootcamp.movies.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private String title;
    private Double rating;
    private Integer awards;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime releaseDate;
    private Integer length;
    private GenreDto genre;
}
