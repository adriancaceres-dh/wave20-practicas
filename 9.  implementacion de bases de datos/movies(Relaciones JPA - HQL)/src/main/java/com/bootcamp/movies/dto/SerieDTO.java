package com.bootcamp.movies.dto;

import com.bootcamp.movies.entity.Season;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO {


    private Integer id;

    private String title;
    private LocalDateTime release_date;
    private LocalDateTime end_date;


}
