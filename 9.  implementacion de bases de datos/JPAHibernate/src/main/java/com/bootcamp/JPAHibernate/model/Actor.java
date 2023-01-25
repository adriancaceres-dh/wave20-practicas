package com.bootcamp.JPAHibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Long rating;
    @Column(name = "favorite_movie_id")
    private Long favoriteMovieId;



}
