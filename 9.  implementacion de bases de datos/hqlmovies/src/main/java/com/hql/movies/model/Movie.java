package com.hql.movies.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hql.movies.model.intermediate.ActorMovie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonBackReference
    private List<ActorMovie> actors;
}
