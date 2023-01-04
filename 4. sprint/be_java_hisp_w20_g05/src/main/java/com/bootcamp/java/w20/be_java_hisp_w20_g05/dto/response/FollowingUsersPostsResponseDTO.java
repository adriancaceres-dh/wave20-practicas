package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowingUsersPostsResponseDTO {
    @JsonProperty("user_id")
    private int userId;
    private Collection<PostResponseDTO> posts;
}
