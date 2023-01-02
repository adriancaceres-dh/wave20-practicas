package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;

import java.util.List;

public interface IUserService extends IService<UserResponseDTO> {
    User getById(int id);
    boolean followUser(int userId, int userIdToFollow);
    void unfollowUser(int userId, int userIdToUnfollow);
}
