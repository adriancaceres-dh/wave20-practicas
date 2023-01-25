package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Genre {

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private Integer active;
    private Timestamp createdAt;
    @Id
    private Integer id;
    @Column(length = 100)
    private String name;
    private Integer ranking;
    private Timestamp updatedAt;
}
