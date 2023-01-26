package com.example.practicaHQL.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    private Integer id;
    /*@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private Integer active;
    private Timestamp createdAt;
    @Column(length = 100)
    private String name;
    private Integer ranking;
    private Timestamp updatedAt;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Serie> serieList;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Movie> movieList;*/
}
