package com.example.practicaHQL.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    private Integer id;
    /*private Timestamp createdAt;
    private Integer number;
    @Column(precision = 3,scale = 1) // No se si esto va al revés.
    private Double rating;
    private Date releaseDate;
    @ManyToOne
    private Season seasonId;
    @Column(length = 500)
    private String title;
    private Timestamp updatedAt;
    @OneToMany
    private List<ActorEpisode> actorMovieList;*/
}
