package com.bootcamp.showroom_elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Document(indexName = "showroom")
public class Sale {
    @Id
    private Long id;
    @Field(type = FieldType.Date)
    private LocalDate date;
    private BigDecimal total;
    private String paymentMethod;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Clothing> clothes;
}
