package com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromosAmountDTO {
    @JsonUnwrapped
    private UserDTO userDTO;
    private long promoProductsCount;

    public PromosAmountDTO(int userId, String username, long promoProductsCount) {
        this.promoProductsCount = promoProductsCount;
        this.userDTO = new UserDTO(userId, username);
    }
}
