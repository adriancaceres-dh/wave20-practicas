package com.bootcamp.movies_hql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {

    private Long id;
    private String name;
    private int ranking;
    private boolean active;
}
