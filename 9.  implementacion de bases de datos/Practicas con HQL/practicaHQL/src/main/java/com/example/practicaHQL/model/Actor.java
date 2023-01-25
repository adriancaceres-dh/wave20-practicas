package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.sql.Timestamp;

@Entity
public class Actor {

    private Timestamp createdAt;
    private Integer favoriteMovieId;
    @Column(length = 100)
    private String firstName;
    private Integer id;
    @Column(length = 100)
    private String lastName;
    @Column(precision = 3,scale = 1) // No se si esto va al revés.
    private Double rating;
    private Timestamp updatedAt;
}
