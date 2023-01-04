package com.bootcamp.be_java_hisp_w20_g6.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor


public class PostPromoListResponseDto {

    private int user_id;
    private String user_name;
    private List<PostPromoResponseDto> posts;

}
