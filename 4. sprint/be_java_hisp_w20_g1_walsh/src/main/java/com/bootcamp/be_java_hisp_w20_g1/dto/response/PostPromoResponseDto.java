package com.bootcamp.be_java_hisp_w20_g1.dto.response;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostBaseDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoResponseDto extends PostBaseDto {

    private int postId;
    private boolean hasPromo;
    private double discount;


}
