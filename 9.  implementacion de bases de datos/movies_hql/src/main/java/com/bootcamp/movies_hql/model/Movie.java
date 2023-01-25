package com.bootcamp.movies_hql.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(nullable = false)
    private Double rating;
    @Column(nullable = false)
    private Integer awards;
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    private Integer length;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
    @OneToMany(mappedBy = "movie")
    private Set<ActorMovie> actorMovies;
}
