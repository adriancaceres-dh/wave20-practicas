package com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoCounResponseDto extends UserResponseBaseDto{
    int promoProductsCount;

    public PostPromoCounResponseDto(int userId, String userName, int promoProductsCount) {
        super(userId, userName);
        this.promoProductsCount = promoProductsCount;
    }
}
