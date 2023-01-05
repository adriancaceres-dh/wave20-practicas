package com.socialmeli.be_java_hisp_w20_g8.models;

import java.time.LocalDate;

public class Post {
    private Integer id;
    private int userId;
    private LocalDate date;
    private Integer product_id;
    private Integer category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post(Integer id, int userId, LocalDate date, Integer product_id, Integer category, double price) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.product_id = product_id;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0;
    }

    public Post(Integer id, LocalDate date, Integer product_id, Integer category, double price, boolean hasPromo, double discount) {
        this.id = id;
        this.date = date;
        this.product_id = product_id;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Post(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public void setProductId(Integer idProduct) {
        this.product_id = idProduct;
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

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
