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
@Table(name="genres")
public class Genre {
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

    @Column(name = "name", length = 100,nullable = false)
    private String name;

    @Column(name = "ranking",nullable = false)
    private Integer ranking;

    @Column(name = "active",nullable = false)
    private Boolean active;

    @OneToMany()
    @JoinColumn(name = "genre_id",referencedColumnName = "id")
    private List<Movie> movies;

    @OneToMany()
    @JoinColumn(name = "genre_id",referencedColumnName = "id")
    private List<Serie> series;
}
