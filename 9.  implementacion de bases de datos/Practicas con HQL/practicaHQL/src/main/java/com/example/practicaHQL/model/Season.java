package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Season {
    private Timestamp createdAt;
    private Date endDate;
    private Integer id;
    private Integer number;
    private Date releaseDate;
    private Integer serieId;
    @Column(length = 500)
    private String title;
    private Timestamp updatedAt;
}
