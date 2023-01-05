package com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostPromoDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoListResponseDTO {

    private int userId;

    private String userName;

    private List<PostPromoDTO> posts;


}
