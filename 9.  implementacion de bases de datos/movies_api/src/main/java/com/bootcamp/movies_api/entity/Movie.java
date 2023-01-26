package com.bootcamp.movies_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date created_at;
    private Date updated_at;
    private String title;

    private Double rating;
    private Integer awards;
    private Date release_date;
    private Integer length;
    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    Set<Actor> cast;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

}
