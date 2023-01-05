package com.socialmeli.be_java_hisp_w20_g8.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PostDTO {
    private int user_id;
    private int post_id;
    private LocalDate date;
    private ProductDTO product;
    private int category;
    private double price;
    private boolean has_promo;
    private Double discount;

    public PostDTO(int user_id, LocalDate date, ProductDTO product, int category, double price) {
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
