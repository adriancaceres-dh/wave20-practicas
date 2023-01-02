package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;
import org.springframework.http.ResponseEntity;

public interface IUserService {

    UserFollowersResponseDto getSellerFollowersDto(int id, String order);
    UserFollowersCountResponseDto getFollowersCountDto(int id);
    UserFollowedResponseDto getFollowedDto(int id, String order);
    ResponseEntity<UserFollowedResponseDto> followUser(int userId, int userIdToFollow);
    ResponseEntity<UserFollowedResponseDto> unfollowUser(int userId, int userIdToUnfollow);

    boolean alreadyExists(int userId);

    void updateUser(int userId);
}
