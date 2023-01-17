package com.bootcamp.be_java_hisp_w20_g2_podio.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserFollowersResponseDTO extends UserResponseDTO {

    private List<UserResponseDTO> followers;

    public UserFollowersResponseDTO(int userId, String userName, List<UserResponseDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }

}
