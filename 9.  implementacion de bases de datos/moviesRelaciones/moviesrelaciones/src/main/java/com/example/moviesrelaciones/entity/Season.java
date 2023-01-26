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
@Table(name="seasons")
public class Season {
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

    @Column(name = "title", length = 500)
    private String title;

    @Column(name="number")
    private Integer number;

    @Column(name = "release_date",nullable = false)
    private LocalDate releaseDate;

    @Column(name = "end_date",nullable = false)
    private LocalDate endDate;

    @OneToMany()
    @JoinColumn(name = "season_id",referencedColumnName = "id")
    private List<Episode> episodes;
}
