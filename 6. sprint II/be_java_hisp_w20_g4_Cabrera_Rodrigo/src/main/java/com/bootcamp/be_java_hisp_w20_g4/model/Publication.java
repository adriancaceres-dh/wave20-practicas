package com.bootcamp.be_java_hisp_w20_g4.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    private int post_id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Double price;
    private boolean hasPromo;
    private double discount;
    private Product product;
    private Category category;

    private int user_id;
    private static int contador = 3;

    public Publication(LocalDate date, double price, Product product, Category category, int user_id) {
        this.user_id = user_id;
        this.date = date;
        this.price = price;
        this.product = product;
        this.category = category;
        contador++;
        this.post_id = contador;
    }

    public Publication(LocalDate date, Double price, Product product, Category category, Integer userId, Boolean hasPromo, Double discount) {
        this.user_id = userId;
        this.date = date;
        this.price = price;
        this.product = product;
        this.category = category;
        this.hasPromo = hasPromo;
        this.discount = discount;
        contador++;
        this.post_id = contador;
    }
}
