package com.bootcamp.movies.model;

import com.bootcamp.movies.model.intermediate.ActorMovie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    @Column(name = "release_date")
    private LocalDateTime releaseDate;
    private Integer length;
    @ManyToOne
    private Genre genre;
    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private Set<ActorMovie> actorMovies;
}
