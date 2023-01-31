package com.bootcamp.movies.entity;

import com.bootcamp.movies.entity.intermediate.ActorMovie;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    @Column(name = "release_date")
    private LocalDateTime releaseDate;
    private Integer length;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<ActorMovie> actors;

}
