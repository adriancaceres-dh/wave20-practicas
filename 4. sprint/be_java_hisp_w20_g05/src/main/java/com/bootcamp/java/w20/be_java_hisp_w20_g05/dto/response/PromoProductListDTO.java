package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class PromoProductListDTO {

    private int user_id;
    private String user_name;
    private List<PromoPostResponseDTO> posts;
}
