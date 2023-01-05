package com.bootcamp.be_java_hisp_w20_g2_idalgo.utils.mapper;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserFollowersCountResponseDTO toCountDTO(User user) {
        UserFollowersCountResponseDTO userFollowersCountResponseDTO = new UserFollowersCountResponseDTO();
        userFollowersCountResponseDTO.setUserId(user.getId());
        userFollowersCountResponseDTO.setUserName(user.getUserName());
        userFollowersCountResponseDTO.setFollowersCount(user.getFollowers().size());
        return userFollowersCountResponseDTO;
    }
}
