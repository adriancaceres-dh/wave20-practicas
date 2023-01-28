package com.example.peliculas.dto;

import com.example.peliculas.entity.Actor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EpisodeDto {



        private Long id;

        private LocalDate createdAt;

        private LocalDate updateAt;

        private String title;

        private Integer number;

        private LocalDate releaseDate;

        private double rating;

        private List<Actor> actors;
}
