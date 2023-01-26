package com.example.Practica.HQL.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "int(11) unsigned")
    private Integer id;
    @Column(columnDefinition = "timestamp")
    private LocalDate createdAt;
    @Column(columnDefinition = "timestamp")
    private LocalDate updatedAt;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "datetime", nullable = false)
    private LocalDate releaseDate;
    @Column(columnDefinition = "datetime", nullable = false)
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", columnDefinition = "int(11) unsigned")
    private Genre genre;
    @JsonIgnore
    @OneToMany(mappedBy = "serie")
    private List<Season> seasons;

}
