package com.bootcamp.movies.model;

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
@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String title;
    @Column(name = "release_date")
    private LocalDateTime releaseDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @ManyToOne
    private Genre genre;
    @OneToMany(mappedBy = "serie")
    private List<Season> season;
}
