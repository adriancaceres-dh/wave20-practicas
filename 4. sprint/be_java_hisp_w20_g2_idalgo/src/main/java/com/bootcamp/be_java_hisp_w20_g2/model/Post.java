package com.bootcamp.be_java_hisp_w20_g2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@AllArgsConstructor
@Data
public class Post {
    private Integer id;
    private LocalDate date;
    private Product product;
    private PostCategory postCategory;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post(LocalDate date, Product product, PostCategory postCategory, double price) {
        this.date = date;
        this.product = product;
        this.postCategory = postCategory;
        this.price = price;
        hasPromo = false;
        discount = 0;
    }

    public Post(LocalDate date, Product product, PostCategory postCategory, double price, boolean hasPromo, double discount) {
        this.date = date;
        this.product = product;
        this.postCategory = postCategory;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
