package com.socialmeli.be_java_hisp_w20_g8.models;

import lombok.Data;

import java.time.LocalDate;

public class Post {
    private Integer id;
    private LocalDate date;
    private Integer idProduct;
    private Integer category;
    private double price;

    public Post(Integer id, LocalDate date, Integer idProduct, Integer category, double price) {
        this.id = id;
        this.date = date;
        this.idProduct = idProduct;
        this.category = category;
        this.price = price;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setProduct(Integer idProduct) {
        this.idProduct = idProduct;
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

}
