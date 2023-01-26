package com.example.elasticBaseConfigTest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "blog")
public class Articulo {
    @Id
    private String id;
    private String titulo;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Autor> autores;
}




