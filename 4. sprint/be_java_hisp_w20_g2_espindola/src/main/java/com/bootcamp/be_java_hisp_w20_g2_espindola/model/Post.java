package com.bootcamp.be_java_hisp_w20_g2_espindola.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@AllArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Post {
    private Integer id;
    private LocalDate date;
    private Product product;
    private Category category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post(LocalDate date, Product product, Category category, double price) {
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public Post(LocalDate date, Product product, Category category, double price, boolean hasPromo, double discount) {
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
