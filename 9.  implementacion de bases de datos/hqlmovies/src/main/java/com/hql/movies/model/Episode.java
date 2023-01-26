package com.hql.movies.model;

import com.hql.movies.model.intermediate.ActorEpisode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
    private Integer seasonId;

    @OneToMany(
            mappedBy = "episode",
            cascade = CascadeType.ALL
    )
    private List<ActorEpisode> actors;
}
