package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserExtendedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;

import java.util.List;


public interface IUserService {
    List<UserExtendedDTO> getUsers(String order);
    String addFollower(int userId, int userIdToFollow);
    UserFollowerCountDTO getFollowerCount(int userId);
    UserFollowersDTO getFollowersList(int userId, String order);
    UserFollowersDTO getFollowedList(int userId, String order);
    String unfollow(int userId, int UserIdToUnfollow);
    String addUser(UserDTO userDTO);
}
