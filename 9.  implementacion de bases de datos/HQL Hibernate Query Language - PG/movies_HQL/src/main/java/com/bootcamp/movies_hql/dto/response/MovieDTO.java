package com.bootcamp.movies_hql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate release_date;
    private Integer length;
    private GenreDTO genre;
//    private List<ActorDTO> actors;
}
