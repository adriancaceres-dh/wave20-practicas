package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_post_list;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.UserPostDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.UserProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserPromoPostDTO extends UserPostDTO {
    @JsonProperty("has_promo")
    private boolean promo;
    @JsonProperty("discount")
    private double discount;

    public UserPromoPostDTO(int userId, int postId, LocalDate date, UserProductDTO product, int category, double price, boolean promo, double discount) {
        super(userId, postId, date, product, category, price);
        this.promo = promo;
        this.discount = discount;
    }
}
