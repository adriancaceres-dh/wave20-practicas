package com.socialmeli.be_java_hisp_w20_g8.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Post {
    private Integer id;
    private int user_id;
    private LocalDate date;
    private Integer product_id;
    private Integer category;
    private double price;
    private boolean has_promo;
    private double discount;

    public Post(Integer id, int user_id, LocalDate date, Integer product_id, Integer category, double price, boolean has_promo, double discount) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.product_id = product_id;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public Post() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHas_promo() {
        return has_promo;
    }

    public void setHas_promo(boolean has_promo) {
        this.has_promo = has_promo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
