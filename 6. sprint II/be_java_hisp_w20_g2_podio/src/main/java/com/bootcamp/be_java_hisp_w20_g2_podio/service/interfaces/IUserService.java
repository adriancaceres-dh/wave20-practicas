package com.bootcamp.be_java_hisp_w20_g2_podio.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.UserFollowedResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.UserFollowersResponseDTO;

import java.util.Optional;

public interface IUserService {

    UserFollowersResponseDTO findAllFollowers(int userId, Optional<String> order);

    UserFollowedResponseDTO findAllFollowed(int userId, Optional<String> order);

    String unfollowUser(int userId, int userIdToUnfollow);

    boolean follow(Integer idFollower, Integer idFollowed);

    UserFollowersCountResponseDTO followerList(Integer id);

}
