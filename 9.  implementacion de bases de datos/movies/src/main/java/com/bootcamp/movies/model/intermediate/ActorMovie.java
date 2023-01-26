package com.bootcamp.movies.model.intermediate;

import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.model.Movie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actor_movie")
public class ActorMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonBackReference
    private Actor actor;
    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonManagedReference
    private Movie movie;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
