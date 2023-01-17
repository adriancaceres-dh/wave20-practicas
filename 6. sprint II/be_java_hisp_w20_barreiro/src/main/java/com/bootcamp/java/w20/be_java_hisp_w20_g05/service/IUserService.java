package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersBySellerDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService extends IService<UserResponseDTO> {

    public FollowersCountDTO getFollowersCount (int id);
    User getById(int id);
    public UserResponseDTO followUser(int userId, int userIdToFollow);
    public UserResponseDTO unfollowUser(int userId, int userIdToUnfollow);
    FollowedListDTO getFollowedListDto(int userId, String order);
    public FollowersBySellerDTO getFollowersBySeller(int userId, String order);
}
