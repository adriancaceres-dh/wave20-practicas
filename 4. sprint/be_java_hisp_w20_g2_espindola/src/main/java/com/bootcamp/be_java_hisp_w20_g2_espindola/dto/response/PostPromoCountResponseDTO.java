package com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoCountResponseDTO extends UserResponseDTO{
    private int promoProductsCount;

    public PostPromoCountResponseDTO(int userId, String userName, int promoProductsCount) {
        super(userId, userName);
        this.promoProductsCount = promoProductsCount;
    }

}
