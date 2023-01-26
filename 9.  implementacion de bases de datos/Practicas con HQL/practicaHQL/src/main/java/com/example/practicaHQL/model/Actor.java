package com.example.practicaHQL.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "actors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Column(name = "created_at")
    private Timestamp createdAt;
    @ManyToOne
    private Movie favoriteMovieId;
    @Column(length = 100, name ="first_name")
    private String firstName;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100,name = "last_name")
    private String lastName;
    @Column(precision = 3, scale = 1) // No se si esto va al revés.
    private Double rating;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @OneToMany()
    private List<ActorEpisode> actorEpisodeList;
    @OneToMany()
    private List<ActorMovie> actorMovieList;
}
