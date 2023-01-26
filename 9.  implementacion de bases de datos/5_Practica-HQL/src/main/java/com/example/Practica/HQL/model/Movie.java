package com.example.Practica.HQL.model;

import com.example.Practica.HQL.model.relationships.ActorMovie;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "int(11) unsigned")
    private Integer id;
    @Column(columnDefinition = "timestamp")
    private LocalDate createdAt;
    @Column(columnDefinition = "timestamp")
    private LocalDate updatedAt;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "decimal(3,1) unsigned", nullable = false)
    private Double rating;
    @Column(columnDefinition = "int(11) unsigned", nullable = false)
    private Integer awards;
    @Column(columnDefinition = "datetime", nullable = false)
    private LocalDate releaseDate;
    @Column(columnDefinition = "int(11) unsigned")
    private Integer lenght;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", columnDefinition = "int(11) unsigned")
    private Genre genre;
    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<ActorMovie> actorMovies;

}
