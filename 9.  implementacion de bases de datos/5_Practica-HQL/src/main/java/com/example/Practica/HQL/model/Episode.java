package com.example.Practica.HQL.model;

import com.example.Practica.HQL.model.relationships.ActorEpisode;
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
@Entity(name="episodes")
public class Episode {

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
    @Column(columnDefinition = "decimal(3,1)", nullable = false)
    private Double rating;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", columnDefinition = "int(11) unsigned")
    private Season season;

    @OneToMany(mappedBy = "episode")
    @JsonIgnore
    private List<ActorEpisode> actorEpisodes;

}
