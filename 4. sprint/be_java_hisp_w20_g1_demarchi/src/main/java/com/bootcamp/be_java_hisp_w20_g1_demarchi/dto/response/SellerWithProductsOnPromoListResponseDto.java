package com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SellerWithProductsOnPromoListResponseDto extends UserResponseBaseDto{

    private List<PostPromoResponseDto> posts;

    public SellerWithProductsOnPromoListResponseDto(int userId, String userName, List<PostPromoResponseDto> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
