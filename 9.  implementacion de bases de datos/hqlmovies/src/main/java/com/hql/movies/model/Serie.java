package com.hql.movies.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;

    private Integer genreId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "serieId")
    private List<Season> seasons;

}
