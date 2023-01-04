package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PromoPostListResponseDTO {
    private int user_id;
    private String user_name;
    private List<PromoPostResponseDTO> posts;

}
