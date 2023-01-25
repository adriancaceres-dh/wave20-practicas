package com.bootcamp.movies_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date created_at;
    private Date updated_at;
    private String title;

    private Double rating;
    private Integer awards;
    private Date release_date;
    private Integer length;


    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

}
