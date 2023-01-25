package com.example.practicaHQL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Migration {

    private Integer batch;
    private Integer id;
    @Column(length = 255)
    private String migration;
}
