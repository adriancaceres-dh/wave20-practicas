package com.bootcamp.miniseries.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MiniSerieDTO {
    private String name;
    private Double rating;
    private int amountOfAwards;
}
