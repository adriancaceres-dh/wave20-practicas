package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_posts;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserPostDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PromoPostsResponse {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("posts")
    private Collection<PromoPostsDTO> posts;

}
