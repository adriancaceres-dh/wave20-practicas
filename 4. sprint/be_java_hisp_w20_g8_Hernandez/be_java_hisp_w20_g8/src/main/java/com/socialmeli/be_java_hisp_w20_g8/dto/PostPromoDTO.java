package com.socialmeli.be_java_hisp_w20_g8.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialmeli.be_java_hisp_w20_g8.models.PostPromo;
import com.socialmeli.be_java_hisp_w20_g8.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class PostPromoDTO {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("post_id")
    private int postId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    @JsonProperty("product")
    private Product product;
    private Integer category;
    private double price;
    @JsonProperty("has_promo")
    private boolean hashPromo;
    private double discount;

    //Constructors
    public PostPromoDTO() {
    }

    public PostPromoDTO(int postId, LocalDate date, Product product, Integer category, double price, boolean hashPromo, double discount) {
        this.postId = postId;
        this.date = date;
        this.category = category;
        this.price = price;
        this.hashPromo = hashPromo;
        this.discount = discount;

    }
}
