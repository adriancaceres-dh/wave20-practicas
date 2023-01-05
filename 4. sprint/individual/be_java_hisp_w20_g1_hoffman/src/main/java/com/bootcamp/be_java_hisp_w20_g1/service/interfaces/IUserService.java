package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserResponseDto;

import java.util.List;
import java.util.Set;

public interface IUserService {

    UserFollowersResponseDto getSellerFollowersDto(int id, String order);
    UserFollowersCountResponseDto getFollowersCountDto(int id);
    UserFollowedResponseDto getFollowedDto(int id, String order);

    List<UserResponseDto> getUserListDto(Set<Integer> users, String order);

    UserResponseDto getUserDtoById(int id);

    UserFollowedResponseDto followUser(int userId, int userIdToFollow);
    UserFollowedResponseDto unfollowUser(int userId, int userIdToUnfollow);
    void validateUserExistById(int id);

    Set<Integer> getUserFollowed(int id);
    boolean alreadyExists(int userId);

    void updateUser(int userId);

    boolean isSeller(int userId);
}
