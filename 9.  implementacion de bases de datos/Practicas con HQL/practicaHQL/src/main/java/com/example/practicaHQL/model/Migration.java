package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "migrations")
public class Migration {
    private Integer batch;
    @Id
    private Integer id;
    @Column(length = 255)
    private String migration;
}
