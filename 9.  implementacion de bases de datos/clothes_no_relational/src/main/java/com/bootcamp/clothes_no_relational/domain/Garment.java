package com.bootcamp.clothes_no_relational.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter @Setter
@Document(indexName = "clothes")
@TypeAlias("garment")
public class Garment {

    @Id
    @Field(type = FieldType.Long)
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    private Double price;
}
