package com.bootcamp.movies.model;

import com.bootcamp.movies.model.intermediate.ActorEpisode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String title;
    private Double rating;
    private Integer number;
    @Column(name = "release_date")
    private LocalDateTime releaseDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @ManyToOne
    private Season season;
    @OneToMany(mappedBy = "episode")
    private Set<ActorEpisode> actorEpisodes;
}
