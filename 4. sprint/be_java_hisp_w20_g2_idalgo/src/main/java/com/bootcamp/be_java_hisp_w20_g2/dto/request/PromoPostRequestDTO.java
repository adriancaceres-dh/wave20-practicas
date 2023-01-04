package com.bootcamp.be_java_hisp_w20_g2.dto.request;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostRequestDTO extends PostDTO {
    private boolean hasPromo;
    private double discount;
}
