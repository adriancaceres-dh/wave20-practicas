package com.bootcamp.java.w20.be_java_hisp_w20_g05.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private int id;
    private int category;
    private int userId;
    private LocalDate date;
    private double price;
    private boolean hasPromo;
    private double discount;
    private Product product;

    public boolean getHasPromo() {
        return discount > 0;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
