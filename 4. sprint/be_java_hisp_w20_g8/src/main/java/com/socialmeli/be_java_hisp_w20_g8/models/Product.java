package com.socialmeli.be_java_hisp_w20_g8.models;

import java.util.Objects;

public class Product {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public Product() {

    }

    public Product(int product_id, String product_name, String type, String brand, String color, String notes) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return product_id == product.product_id && product_name.equals(product.product_name) && type.equals(product.type) && brand.equals(product.brand) && color.equals(product.color) && notes.equals(product.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, product_name, type, brand, color, notes);
    }
}
