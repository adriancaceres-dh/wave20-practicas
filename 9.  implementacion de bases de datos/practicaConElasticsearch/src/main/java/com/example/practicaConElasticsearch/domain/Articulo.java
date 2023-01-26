package com.example.practicaConElasticsearch.domain;

import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.Getter;
import lombok.Setter;

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
