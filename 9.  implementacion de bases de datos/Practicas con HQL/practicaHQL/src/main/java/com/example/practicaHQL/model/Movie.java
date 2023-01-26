package com.example.practicaHQL.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "movies")
public class Movie {
    private Integer awards;
    private Timestamp createdAt;
    @OneToOne(cascade = CascadeType.ALL)
    private Genre genreId;
    @Id
    private Integer id;
    private Integer length;
    private Double reiting;
    @Column(length = 500)
    private String title;
    private Timestamp updatedAt;
}
