package com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
public class UserFollowersResponseDTO {
    @JsonUnwrapped
    private UserDTO user;
    private List<UserDTO> followers;

    public UserFollowersResponseDTO(int userId, String userName, List<UserDTO> followers) {
        this.user = new UserDTO(userId, userName);
        this.followers = followers;
    }

}
