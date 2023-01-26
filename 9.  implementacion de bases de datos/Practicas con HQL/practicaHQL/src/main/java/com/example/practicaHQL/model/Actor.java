package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "actors")
public class Actor {
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "favorite_movie_id")
    private Integer favoriteMovieId;
    @Column(length = 100, name ="first_name")
    private String firstName;
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(length = 100,name = "last_name")
    private String lastName;
    @Column(precision = 3, scale = 1) // No se si esto va al revés.
    private Double rating;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
