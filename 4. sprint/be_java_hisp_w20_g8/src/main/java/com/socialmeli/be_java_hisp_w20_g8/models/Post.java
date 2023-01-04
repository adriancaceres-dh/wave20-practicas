package com.socialmeli.be_java_hisp_w20_g8.models;

import java.time.LocalDate;

public class Post {
    private int id;
    private int userId;
    private LocalDate date;
    private int productId;
    private int categoryId;
    private double price;

    public Post() {
    }

    public Post(int id, LocalDate date, int productId, int categoryId, double price) {
        this.id = id;
        this.date = date;
        this.productId = productId;
        this.categoryId = categoryId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
