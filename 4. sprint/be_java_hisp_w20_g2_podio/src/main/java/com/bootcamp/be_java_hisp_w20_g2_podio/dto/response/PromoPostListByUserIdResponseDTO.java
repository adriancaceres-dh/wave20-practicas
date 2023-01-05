package com.bootcamp.be_java_hisp_w20_g2_podio.dto.response;

import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PostWithIdDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostListByUserIdResponseDTO {
    private int userId;
    private String userName;
    private List<PostWithIdDTO> posts;

    public PromoPostListByUserIdResponseDTO(int userId) {
        this.userId = userId;
        this.posts = new ArrayList<>();
    }

    public void addPost(PostWithIdDTO post) {
        posts.add(post);
    }
}
