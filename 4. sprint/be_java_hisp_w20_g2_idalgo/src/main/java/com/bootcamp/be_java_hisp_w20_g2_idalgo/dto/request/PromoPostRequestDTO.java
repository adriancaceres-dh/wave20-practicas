package com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.request;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.PostDTO;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostRequestDTO {
    @JsonUnwrapped
    private PostDTO post;
    private boolean hasPromo;
    private double discount;
}
