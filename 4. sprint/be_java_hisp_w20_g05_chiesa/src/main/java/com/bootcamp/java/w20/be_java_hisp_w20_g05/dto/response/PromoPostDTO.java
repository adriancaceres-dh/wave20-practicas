package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
public class PromoPostDTO {
    private final boolean hasPromo = true;
    private double discount;
    private FollowedUserProductDTO product;

    public PromoPostDTO(double discount, FollowedUserProductDTO product) {
        //this.hasPromo = true;
        this.discount = discount;
    }
}
