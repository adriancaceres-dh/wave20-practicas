package com.bootcamp.MoviesHQL.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "series")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
