package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<UserFollowedResponseDto> followUser(int userId, int userIdToFollow);
    ResponseEntity<UserFollowedResponseDto> unfollowUser(int userId, int userIdToUnfollow);

    boolean alreadyExists(int userId);

    void verifyUser();
}
