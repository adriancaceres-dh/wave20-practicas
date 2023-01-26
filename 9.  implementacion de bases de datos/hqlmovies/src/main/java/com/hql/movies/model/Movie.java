package com.hql.movies.model;


import com.hql.movies.model.intermediate.ActorMovie;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;

    private Integer genreId;

    @OneToMany(
            mappedBy = "movie",
            cascade = CascadeType.ALL
    )
    private List<ActorMovie> actors;
}
