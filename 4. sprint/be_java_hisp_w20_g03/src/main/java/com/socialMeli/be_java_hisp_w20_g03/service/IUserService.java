package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IUserService {
    List<UserDTO> getUsers();
    public ResponseEntity<String> addFollower(int userId, int userIdToFollow);
    public UserFollowerCountDTO getFollowerCount(int userId);
    public UserFollowersDTO getFollowersList(int userId, String order);
    public UserFollowersDTO getFollowedList(int userId, String order);
    public ResponseEntity<String> unfollow(int userId, int UserIdToUnfollow);
}
