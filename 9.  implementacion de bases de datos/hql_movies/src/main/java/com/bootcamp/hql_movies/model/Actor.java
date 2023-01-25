package com.bootcamp.hql_movies.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Actor {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(precision = 4, scale = 1)
    private BigDecimal rating;

    @ManyToMany
    @JoinTable(
            name = "actor_episode",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id")
    )
    @ToString.Exclude
    private Set<Episode> episodes;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @ToString.Exclude
    private Set<Movie> movies;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movie favoriteMovie;

}