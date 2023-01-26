package com.bootcamp.movies_hql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private double rating;
    @OneToOne
    private Movie favorite_movie;

}
