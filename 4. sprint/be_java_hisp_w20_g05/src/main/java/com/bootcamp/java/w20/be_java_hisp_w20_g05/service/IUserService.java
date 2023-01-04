package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowingListDTO;

public interface IUserService extends IService<UserResponseDTO> {

    public FollowersCountDTO getFollowersCount (int id);
    public boolean followUser(int userId, int userIdToFollow);
    public boolean unfollowUser(int userId, int userIdToUnfollow);
    FollowingListDTO getFollowingList(int userId, String order);
    public FollowersListDTO getFollowersList(int userId, String order);
}
