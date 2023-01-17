package com.bootcamp.be_java_hisp_w20_g2_alderete.dto.request;

import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromotionRequestDTO extends PostDTO {
    private boolean hasPromo;
    private double discount;
}
