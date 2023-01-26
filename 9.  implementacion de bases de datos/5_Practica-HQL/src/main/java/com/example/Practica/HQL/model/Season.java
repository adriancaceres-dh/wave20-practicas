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
@Entity(name="seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "int(11) unsigned")
    private Integer id;
    @Column(columnDefinition = "timestamp")
    private LocalDate createdAt;
    @Column(columnDefinition = "timestamp")
    private LocalDate updatedAt;
    @Column(length = 500)
    private String title;
    @Column(columnDefinition = "int(11) unsigned")
    private Integer number;
    @Column(columnDefinition = "datetime", nullable = false)
    private LocalDate releaseDate;
    @Column(columnDefinition = "datetime", nullable = false)
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", columnDefinition = "int(11) unsigned")
    private Serie serie;

}
