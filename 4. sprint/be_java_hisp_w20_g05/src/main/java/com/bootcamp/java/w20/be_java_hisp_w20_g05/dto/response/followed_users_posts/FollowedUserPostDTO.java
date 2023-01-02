package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts;

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
public class FollowedUserPostDTO {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("post_id")
    private int postId;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("product")
    private FollowedUserProductDTO product;
    @JsonProperty("category")
    private String category;
    @JsonProperty("price")
    private double price;

}
