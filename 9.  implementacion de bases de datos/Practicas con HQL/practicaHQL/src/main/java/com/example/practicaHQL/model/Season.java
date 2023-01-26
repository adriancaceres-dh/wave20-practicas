package com.example.practicaHQL.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    private Integer id;
/*    private Timestamp createdAt;
    private Date endDate;
    private Integer number;
    private Date releaseDate;
    @ManyToOne
    private Serie serieId;
    @Column(length = 500)
    private String title;
    private Timestamp updatedAt;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "seasonId")
    private List<Episode> episodios;*/
}
