package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Episode {

    private Timestamp createdAt;
    private Integer id;
    private Integer number;
    @Column(precision = 3,scale = 1) // No se si esto va al revés.
    private Double rating;
    private Date releaseDate;
    private Integer seasonId;
    @Column(length = 500)
    private String title;
    private Timestamp updatedAt;
}
