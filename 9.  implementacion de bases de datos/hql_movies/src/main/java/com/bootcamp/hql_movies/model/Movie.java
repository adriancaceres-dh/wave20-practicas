package com.bootcamp.hql_movies.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
public class Movie {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false, precision = 4, scale = 1)
    private BigDecimal rating;

    @Column(nullable = false)
    private Integer awards;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column
    private Integer length;

    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}