package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
public class PromoPostDTO extends FollowedUserProductDTO{
    private boolean hasPromo;
    private double discount;

    public PromoPostDTO(int productId, String productName, String type, String brand, String color, String notes, boolean hasPromo, double discount) {
        super(productId, productName, type, brand, color, notes);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
