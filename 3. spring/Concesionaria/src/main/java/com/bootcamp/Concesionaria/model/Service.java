package com.bootcamp.Concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Service {
    private String date;
    private String kilometers;
    private String description;
}
