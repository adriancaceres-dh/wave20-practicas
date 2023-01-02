package com.bootcamp.be_java_hisp_w20_g2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Builder
public class UserFollowedResponseDTO extends UserResponseDTO{

    private List<UserResponseDTO> followed;

}
