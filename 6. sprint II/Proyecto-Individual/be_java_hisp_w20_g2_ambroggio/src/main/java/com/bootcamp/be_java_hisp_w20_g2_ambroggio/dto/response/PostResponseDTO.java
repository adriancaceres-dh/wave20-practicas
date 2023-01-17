package com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.response;

import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.PostWithIdDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostResponseDTO {
    private int userId;
    private List<PostWithIdDTO> posts;

    public PostResponseDTO(int userId) {
        this.userId = userId;
        posts = new ArrayList<>();
    }

    public void addPost(PostWithIdDTO post) {
        posts.add(post);
    }
}