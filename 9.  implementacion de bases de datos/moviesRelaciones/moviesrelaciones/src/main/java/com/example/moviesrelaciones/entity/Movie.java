package com.example.moviesrelaciones.entity;

import ch.qos.logback.core.util.Loader;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "title", length = 500,nullable = false)
    private String title;

    @Column(name = "rating",precision=1, scale=2,nullable = false)
    private Double rating;

    @Column(name = "awards",nullable = false)
    private Integer awards;

    @Column(name = "release_date",nullable = false)
    private LocalDate releaseDate;

    @Column(name = "length")
    private Integer legth;

    @OneToMany()
    @JoinColumn(name = "movie_id",nullable = false)
    private List<ActorMovie> actorMovies;

}
