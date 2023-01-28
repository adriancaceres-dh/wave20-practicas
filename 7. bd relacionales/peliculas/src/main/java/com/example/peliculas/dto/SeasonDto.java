package com.example.peliculas.dto;

import com.example.peliculas.entity.Serie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeasonDto {

    private Long id;

    private LocalDate createdAt;

    private LocalDate updateAt;

    private String title;

    private Integer number;

    private LocalDate releaseDate;

    private LocalDate endDate;

    private Serie serie;
}
