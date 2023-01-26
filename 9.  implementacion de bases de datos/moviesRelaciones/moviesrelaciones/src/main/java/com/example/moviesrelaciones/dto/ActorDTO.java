package com.example.moviesrelaciones.dto;

import com.example.moviesrelaciones.entity.ActorEpisode;
import com.example.moviesrelaciones.entity.ActorMovie;
import com.example.moviesrelaciones.entity.Episode;
import com.example.moviesrelaciones.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {

    private Integer id;

    private Date createdAt;

    private Date updatedAt;

    private String first_name;

    private String last_name;

    private Double rating;

    private List<MovieDTO> movies;
}
