package com.example.ejerciciosPracticosEmpleadosYProductos.Domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "blog")
@Getter
@Setter
public class Articulo {
    @Id
    private String id;
    private String titulo;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Autor> autores;
}
