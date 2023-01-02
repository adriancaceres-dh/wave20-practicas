package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowedListDTO {
    private int user_id;
    private String user_name;
    public List<UserResponseDTO> followed = new ArrayList<>();

    public FollowedListDTO(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }
}
