package com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response;

import com.bootcamp.be_java_hisp_w20_g1_berthet.model.Post;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoListResponseDto extends UserResponseBaseDto{

    List<PostResponseDto> posts;

    public PostPromoListResponseDto(int userId, String userName, List<PostResponseDto> posts) {
        super(userId,userName);
        this.posts = posts;
    }
}
