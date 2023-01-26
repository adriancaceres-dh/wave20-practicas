package com.example.moviesrelaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Integer id;


    private Date createdAt;


    private Date updatedAt;

    private String title;


    private Double rating;

    private Integer awards;


    private LocalDate releaseDate;


    private Integer legth;
}
