package com.hql.movies.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String name;
    private Integer ranking;
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "genreId")
    private List<Movie> movies;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "genreId")
    private List<Serie> series;

}
