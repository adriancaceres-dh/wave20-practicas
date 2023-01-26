package com.hql.movies.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
    @OneToMany(
            mappedBy = "actor",
            cascade = CascadeType.ALL
    )
    private List<ActorEpisode> episodes;
    @OneToOne
    private Movie favoriteMovie;
}
