package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "episodes")
public class Episode {
    private Timestamp createdAt;
    @Id
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
