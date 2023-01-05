package com.bootcamp.be_java_hisp_w20_g1.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoRequestDto extends PostBaseDto {
    private boolean hasPromo;
    private double discount;

    public double getDiscount() {
        return discount;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public boolean getHasPromo() {
        return hasPromo;
    }
}
