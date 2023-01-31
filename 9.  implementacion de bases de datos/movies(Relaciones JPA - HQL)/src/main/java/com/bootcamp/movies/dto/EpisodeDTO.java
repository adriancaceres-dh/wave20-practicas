package com.bootcamp.movies.dto;

import com.bootcamp.movies.entity.Season;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EpisodeDTO {

    private Integer id;

    private String title;
    private Integer number;
    private LocalDateTime release_date;
    private Double rating;

}

