package com.bootcamp.be_java_hisp_w20_g1.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoListResponseDto extends UserResponseBaseDto {

    private List<PostResponseDto> posts;

    public PostPromoListResponseDto(int userId, String userName, List<PostResponseDto> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
