package com.bootcamp.be_java_hisp_w20_ramosruiz.service.interfaces;

import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.UserFollowersResponseDto;

import java.util.Set;

public interface IUserService {

    UserFollowersResponseDto getSellerFollowersDto(int id, String order);
    UserFollowersCountResponseDto getFollowersCountDto(int id);
    UserFollowedResponseDto getFollowedDto(int id, String order);
    UserFollowedResponseDto followUser(int userId, int userIdToFollow);
    UserFollowedResponseDto unfollowUser(int userId, int userIdToUnfollow);
    void validateUserExistById(int id);
    void validateUserIsSellerById(int id);

    Set<Integer> getUserFollowed(int id);
    boolean alreadyExists(int userId);

    void updateUser(int userId);
    String getUserName(int id);
}
