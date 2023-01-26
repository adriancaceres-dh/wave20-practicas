package com.bootcamp.movies_hql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeasonDTO {

    private Long id;
    private String title;
    private int number;
    private LocalDate release_date;
    private LocalDate end_date;
    private SerieDTO serie;
}
