package com.socialmeli.be_java_hisp_w20_g8.models;

import java.time.LocalDate;

public class Post {
    private Integer id;
    private int user_id;
    private LocalDate date;
    private Integer product_id;
    private Integer category;
    private double price;
    private Boolean has_promo;
    private Double discount;

    public Post(Integer id, int user_id, LocalDate date, Integer product_id, Integer category, double price) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.product_id = product_id;
        this.category = category;
        this.price = price;
    }

    public Post(){

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

    public Boolean getHas_promo() {
        return has_promo;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", date=" + date +
                ", product_id=" + product_id +
                ", category=" + category +
                ", price=" + price +
                ", has_promo=" + has_promo +
                ", discount=" + discount +
                '}';
    }
}
