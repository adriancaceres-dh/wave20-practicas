package com.hql.movies.dto.response;

import lombok.*;


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
