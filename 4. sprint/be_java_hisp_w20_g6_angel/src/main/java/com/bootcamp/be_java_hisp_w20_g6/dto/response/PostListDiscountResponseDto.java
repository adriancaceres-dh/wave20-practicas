package com.bootcamp.be_java_hisp_w20_g6.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostListDiscountResponseDto {

    private int user_id;
    private String user_name;
    private List<PostDiscountResponseDto> posts;

}
