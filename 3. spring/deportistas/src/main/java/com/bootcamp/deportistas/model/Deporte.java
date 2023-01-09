package com.bootcamp.deportistas.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Deporte {
    private String nombre;
    private List<String> nivel;
}
