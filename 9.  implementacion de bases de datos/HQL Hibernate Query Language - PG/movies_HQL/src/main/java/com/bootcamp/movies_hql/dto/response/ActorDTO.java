package com.bootcamp.movies_hql.dto.response;

import com.bootcamp.movies_hql.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private double rating;
//    private Movie favoriteMovie;
}
