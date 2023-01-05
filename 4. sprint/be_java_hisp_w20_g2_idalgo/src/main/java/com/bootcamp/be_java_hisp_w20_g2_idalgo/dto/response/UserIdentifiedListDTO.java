package com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response;

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
public class UserIdentifiedListDTO<T> {
    private int userId;
    private List<T> posts;

    public UserIdentifiedListDTO(int userId) {
        this.userId = userId;
        posts = new ArrayList<>();
    }

    public void addPost(T post) {
        posts.add(post);
    }
}