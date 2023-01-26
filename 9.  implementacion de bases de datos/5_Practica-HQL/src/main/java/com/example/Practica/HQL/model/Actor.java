package com.example.Practica.HQL.model;

import com.example.Practica.HQL.model.relationships.ActorEpisode;
import com.example.Practica.HQL.model.relationships.ActorMovie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name="actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",columnDefinition = "int(11) unsigned")
    private Integer id;
    @Column(columnDefinition = "timestamp")
    private LocalDate createdAt;
    @Column(columnDefinition = "timestamp")
    private LocalDate updatedAt;
    @Column(name="first_name", length = 100, nullable = false)
    private String firstName;
    @Column(name="last_name", length = 100, nullable = false)
    private String lastName;
    @Column(columnDefinition = "decimal(3,1)")
    private Double rating;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", columnDefinition = "int(11) unsigned")
    private Movie favoriteMovie;
    @JsonIgnore
    @OneToMany(mappedBy = "actor")
    private List<ActorMovie> actorMovies;
    @JsonIgnore
    @OneToMany(mappedBy = "actor")
    private List<ActorEpisode> actorEpisodes;

}
