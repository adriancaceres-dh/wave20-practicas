package com.bootcamp.movies_api.dto.response;

import com.bootcamp.movies_api.entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDTO {
    private String title;
    private Double rating;
    private Integer awards;
    private Date release_date;
    private Integer length;
    private String genre;
    Set<CastMemberResponseDTO> cast;
}
