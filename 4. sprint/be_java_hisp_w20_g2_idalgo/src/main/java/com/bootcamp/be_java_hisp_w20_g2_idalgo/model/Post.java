package com.bootcamp.be_java_hisp_w20_g2_idalgo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@AllArgsConstructor
@Data
public class Post {
    private Integer id;
    private User author;
    private LocalDate date;
    private Product product;
    private Category category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post(LocalDate date, Product product, Category category, double price, User author) {
        this.author = author;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        hasPromo = false;
        discount = 0;
    }

    public Post(LocalDate date, Product product, Category category, double price, User author, boolean hasPromo, double discount) {
        this.author = author;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
