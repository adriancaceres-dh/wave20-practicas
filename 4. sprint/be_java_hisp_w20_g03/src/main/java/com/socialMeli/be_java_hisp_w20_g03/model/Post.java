package com.socialMeli.be_java_hisp_w20_g03.model;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private int postId;
    private int userId;
    private int category;
    private double price;
    private Product product;
    private LocalDate date;
    private boolean hasPromo;
    private double discount;

    public Post(int postId, int userId, int category, double price, Product product, LocalDate date) {
        this.postId = postId;
        this.userId = userId;
        this.category = category;
        this.price = price;
        this.product = product;
        this.date = date;
    }
}
