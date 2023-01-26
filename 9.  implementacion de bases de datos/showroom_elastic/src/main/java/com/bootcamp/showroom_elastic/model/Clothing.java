package com.bootcamp.showroom_elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Getter
@Setter
@Document(indexName = "showroom")
public class Clothing {
    @Id
    private String id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Short amount;
    private BigDecimal sellPrice;
}
