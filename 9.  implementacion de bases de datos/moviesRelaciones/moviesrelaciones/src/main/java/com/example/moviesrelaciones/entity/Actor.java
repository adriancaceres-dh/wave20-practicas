package com.example.moviesrelaciones.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="actors")
public class Actor {
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

    @Column(name = "first_name", length = 100,nullable = false)
    private String first_name;

    @Column(name = "last_name", length = 100,nullable = false)
    private String last_name;

    @Column(name = "rating",precision = 1,scale = 2)
    private Double rating;

    @OneToMany()
    @JoinColumn(name = "actor_id",nullable = false)
    private List<ActorMovie> actorMovies;

    @OneToMany()
    @JoinColumn(name = "actor_id",nullable = false)
    private List<ActorEpisode> actorEpisodes;
}
