package com.example.practicaHQL.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.sql.Timestamp;

@Entity
public class Movie {

    private Integer awards;
    private Timestamp createdAt;
    @OneToOne(cascade = CascadeType.ALL)
    private Genre genreId;
    private Integer id;
    private Integer length;
    private Double reiting;
    @Column(length = 500)
    private String title;
    private Timestamp updatedAt;
}
