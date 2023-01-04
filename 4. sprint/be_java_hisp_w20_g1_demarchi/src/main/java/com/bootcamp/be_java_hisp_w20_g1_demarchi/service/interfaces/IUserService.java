package com.bootcamp.be_java_hisp_w20_g1_demarchi.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.User;

import java.util.Set;

public interface IUserService {

    UserFollowersResponseDto getSellerFollowersDto(int id, String order);
    UserFollowersCountResponseDto getFollowersCountDto(int id);
    UserFollowedResponseDto getFollowedDto(int id, String order);
    UserFollowedResponseDto followUser(int userId, int userIdToFollow);
    UserFollowedResponseDto unfollowUser(int userId, int userIdToUnfollow);
    boolean isSeller(int id);
    void validateUserExistById(int id);
    User getUserById(int id);
    Set<Integer> getUserFollowed(int id);
    boolean alreadyExists(int userId);

    void updateUser(int userId);
}
