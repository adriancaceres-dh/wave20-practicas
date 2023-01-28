package com.example.peliculas.dto;

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
public class MovieDto {
    private Long id;

    private LocalDate createdAt;

    private LocalDate updateAt;

    private String title;

    private Double rating;

    private int awards;

    private LocalDate releasedDate;

    private Integer length;

}
