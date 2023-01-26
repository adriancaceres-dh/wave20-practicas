package com.hql.movies.model;

import com.hql.movies.model.intermediate.ActorEpisode;
import com.hql.movies.model.intermediate.ActorMovie;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;

    @OneToMany(
            mappedBy = "actor",
            cascade = CascadeType.ALL
    )
    private List<ActorMovie> movies;
    @OneToMany(
            mappedBy = "actor",
            cascade = CascadeType.ALL
    )
    private List<ActorEpisode> episodes;
    @OneToOne
    private Movie favoriteMovie;
}
