package com.example.practicaHQL.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Serie {
    @Id
    private Integer id;
    /*@ManyToOne
    private Genre genre_id;
    private Date endDate;
    private Timestamp createdAt;
    private Date releasedDate;
    @Column(length = 500)
    private String title;
    private Timestamp updatedAt;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "season_id")
    private List<Season> seasons;*/
}
