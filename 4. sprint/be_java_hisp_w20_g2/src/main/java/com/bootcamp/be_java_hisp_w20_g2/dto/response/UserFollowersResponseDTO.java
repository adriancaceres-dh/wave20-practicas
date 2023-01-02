package com.bootcamp.be_java_hisp_w20_g2.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserFollowersResponseDTO extends UserResponseDTO{

    private List<UserResponseDTO> followers;

    public UserFollowersResponseDTO(int userId, String userName, List<UserResponseDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }
}
