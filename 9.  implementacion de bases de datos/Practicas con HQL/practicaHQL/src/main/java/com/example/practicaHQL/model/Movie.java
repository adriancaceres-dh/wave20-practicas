package com.example.practicaHQL.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    private Integer id;
    /*private Integer awards;
    private Timestamp createdAt;
    @OneToOne(cascade = CascadeType.ALL)
    private Genre genreId;
    private Integer length;
    private Double reiting;
    @Column(length = 500)
    private String title;
    private Timestamp updatedAt;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ActorMovie> actorMovieList;*/
}
