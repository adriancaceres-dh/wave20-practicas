package com.bootcamp.be_java_hisp_w20_g6.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DiscountPostListResponseDTO {
    private int user_id;
    private String user_name;
    private List<DiscountPostResponseDTO> posts;
}
