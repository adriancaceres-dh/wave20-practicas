package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_posts;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PromoPostsDTO {
    @JsonProperty("post_id")
    private int postId;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("product")
    private FollowedUserProductDTO product;
    @JsonProperty("category")
    private int category;
    @JsonProperty("price")
    private double price;
    @JsonProperty("has_promo")
    private boolean discounted;
    @JsonProperty("discount")
    private double discount;

}
