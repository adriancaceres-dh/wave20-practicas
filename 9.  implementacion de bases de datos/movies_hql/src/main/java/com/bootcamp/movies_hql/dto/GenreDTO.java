package com.bootcamp.movies_hql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class GenreDTO {

    private Integer id;
    private String name;
    private Integer ranking;
    private Boolean active;
    @JsonProperty("created_at")
    private LocalDate createdAt;
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
}
