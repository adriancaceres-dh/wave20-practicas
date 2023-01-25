package com.bootcamp.movies_hql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class SeriesDTO {

    private Integer id;
    private String title;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    @JsonProperty("end_date")
    private LocalDate endDate;
    @JsonProperty("created_at")
    private LocalDate createdAt;
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
    private GenreDTO genre;
}
