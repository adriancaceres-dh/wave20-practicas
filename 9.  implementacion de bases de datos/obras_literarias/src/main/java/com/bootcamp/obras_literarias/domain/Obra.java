package com.bootcamp.obras_literarias.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@Document(indexName = "obras_literarias")
@TypeAlias("obra")
public class Obra {

    @Id
    private Long id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer publicacion;
}
