package com.bootcamp.MoviesHQL.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "episodes")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
