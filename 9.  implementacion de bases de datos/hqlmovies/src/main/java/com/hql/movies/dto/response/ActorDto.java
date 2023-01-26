package com.hql.movies.dto.response;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
}
