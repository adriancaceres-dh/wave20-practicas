package com.bootcamp.be_java_hisp_w20_g2.dto.response;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserPromoProductsListResponseDTO {
    private int userId;
    private String userName;
    private List<PostDTO> posts;
}
