package com.bootcamp.be_java_hisp_w20_g1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostListResponseDto {
    private int userId;
    private List<PostResponseDto> posts;
}
