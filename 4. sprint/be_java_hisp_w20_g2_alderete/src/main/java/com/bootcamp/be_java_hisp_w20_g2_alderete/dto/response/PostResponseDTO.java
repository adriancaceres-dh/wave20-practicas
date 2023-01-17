package com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response;

import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostResponseDTO<T extends PostDTO> {
    private int userId;
    private List<T> posts;

    public PostResponseDTO(int userId) {
        this.userId = userId;
        posts = new ArrayList<>();
    }

    public void addPost(T post) {
        posts.add(post);
    }
}