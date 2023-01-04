package com.bootcamp.be_java_hisp_w20_g6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PostModel {
    private int id;
    private int user_id;
    private LocalDate date;
    private int category;
    private ProductModel product;
    private double price;
    private boolean has_promo;
    private double discount;
    private List<Integer> likes;

    public PostModel() {
        super();
        likes = new ArrayList<>();
    }

}
