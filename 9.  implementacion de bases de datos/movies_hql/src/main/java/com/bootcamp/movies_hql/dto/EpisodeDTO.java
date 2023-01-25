package com.bootcamp.movies_hql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class EpisodeDTO {

    private Integer id;
    private String title;
    private Integer number;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    private Double rating;
    @JsonProperty("created_at")
    private LocalDate createdAt;
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
    private SeasonDTO season;
}
