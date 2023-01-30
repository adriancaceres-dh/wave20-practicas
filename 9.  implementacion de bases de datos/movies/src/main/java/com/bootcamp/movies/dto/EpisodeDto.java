package com.bootcamp.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDto {
    private String title;
    private Integer number;
    private SeasonWithSerieDto season;
}
