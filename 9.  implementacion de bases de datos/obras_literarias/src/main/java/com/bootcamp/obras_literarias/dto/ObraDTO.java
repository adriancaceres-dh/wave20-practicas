package com.bootcamp.obras_literarias.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ObraDTO {

    private Long id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer publicacion;
}
