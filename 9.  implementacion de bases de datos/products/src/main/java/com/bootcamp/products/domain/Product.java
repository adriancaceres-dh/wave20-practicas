package com.bootcamp.products.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@Document(indexName = "products_spring")
@TypeAlias("product")
public class Product {

    @Id
    private Long id;
    private String name;
    private String type;
    private Double price;
    private Double cost;
    private Integer quantity;
}
