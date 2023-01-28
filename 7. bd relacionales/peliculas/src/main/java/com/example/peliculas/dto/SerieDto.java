package com.example.peliculas.dto;

import com.example.peliculas.entity.Season;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class SerieDto {

    private Long id;

    private LocalDate createdAt;

    private LocalDate updateAt;

    private String title;

    private LocalDate releaseDate;

    private LocalDate endDate;

    private List<Season> seasons;
}
