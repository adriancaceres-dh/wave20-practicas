package com.bootcamp.movies_hql.dto.response;

import com.bootcamp.movies_hql.entity.Season;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDTO {

    private Long id;
    private String title;
    private int number;
    private LocalDate release_date;
    private double rating;
    private Season season;
}
