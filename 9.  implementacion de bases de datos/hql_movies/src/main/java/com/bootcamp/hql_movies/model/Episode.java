package com.bootcamp.hql_movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Getter
@Setter
public class Episode {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 500)
    private String title;

    @Column
    private Integer number;

    @Column
    private LocalDate releaseDate;

    @Column
    private BigDecimal rating;

    @ManyToMany(mappedBy = "episodes")
    private Set<Actor> episodeActorEpisodes;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

}
