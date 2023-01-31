package com.bootcamp.movies.entity;

import com.bootcamp.movies.entity.intermediate.ActorMovie;
import com.bootcamp.movies.entity.intermediate.ActorEpisode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="favorite_movie_id", referencedColumnName = "id", nullable = false)
    private Movie favoriteMovie;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    private List<ActorMovie> movies;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    private List<ActorEpisode> series;
}
