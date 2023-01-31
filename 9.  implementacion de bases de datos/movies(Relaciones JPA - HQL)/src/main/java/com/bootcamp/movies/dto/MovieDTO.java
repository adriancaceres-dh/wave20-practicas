package com.bootcamp.movies.dto;

import com.bootcamp.movies.entity.Genre;
import com.bootcamp.movies.entity.intermediate.ActorMovie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDateTime releaseDate;
    private Integer length;

}
