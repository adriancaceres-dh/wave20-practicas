package com.bootcamp.MoviesHQL.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "seasons")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
