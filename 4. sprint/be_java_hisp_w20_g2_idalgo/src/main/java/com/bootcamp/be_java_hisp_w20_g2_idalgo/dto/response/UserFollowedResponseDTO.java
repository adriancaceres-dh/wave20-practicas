package com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Builder
public class UserFollowedResponseDTO {
    @JsonUnwrapped
    private UserDTO userDTO;
    private List<UserDTO> followed;

    public UserFollowedResponseDTO(int userId, String userName, List<UserDTO> followed) {
        this.userDTO = new UserDTO(userId, userName);
        this.followed = followed;
    }
}
