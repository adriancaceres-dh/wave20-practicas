package com.example.peliculas.dto;

import com.example.peliculas.entity.Movie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ActorDto {

    private Long id;

    private LocalDate createdAt;

    private LocalDate updateAt;

    private String firstName;

    private String lastName;

    private Double rating;

    private MovieDto favoriteMovie;
}
