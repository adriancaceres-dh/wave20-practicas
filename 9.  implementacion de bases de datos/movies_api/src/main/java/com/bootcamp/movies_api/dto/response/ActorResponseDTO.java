package com.bootcamp.movies_api.dto.response;

import com.bootcamp.movies_api.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorResponseDTO {
    private String first_name;
    private String last_name;
    private Double rating;
    private String favMovieTitle;
}
