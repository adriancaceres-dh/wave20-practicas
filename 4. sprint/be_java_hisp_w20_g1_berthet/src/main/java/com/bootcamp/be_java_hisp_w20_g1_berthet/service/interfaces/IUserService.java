package com.bootcamp.be_java_hisp_w20_g1_berthet.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.model.User;

import java.util.Set;

public interface IUserService {

    UserFollowersResponseDto getSellerFollowersDto(int id, String order);
    UserFollowersCountResponseDto getFollowersCountDto(int id);
    UserFollowedResponseDto getFollowedDto(int id, String order);
    UserFollowedResponseDto followUser(int userId, int userIdToFollow);
    UserFollowedResponseDto unfollowUser(int userId, int userIdToUnfollow);
    User validateUserExistById(int id);

    Set<Integer> getUserFollowed(int id);
    boolean alreadyExists(int userId);

    String getUsername(int id);
    void updateUser(int userId);
}
