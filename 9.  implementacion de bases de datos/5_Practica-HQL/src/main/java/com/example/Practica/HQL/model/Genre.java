package com.example.Practica.HQL.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "int(11) unsigned")
    private Integer id;
    @Column(columnDefinition = "timestamp")
    private LocalDate createdAt;
    @Column(columnDefinition = "timestamp")
    private LocalDate updatedAt;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(nullable = false, unique = true, columnDefinition = "int(11) unsigned")
    private Integer ranking;
    @Column(nullable = false)
    private Boolean active;

}
