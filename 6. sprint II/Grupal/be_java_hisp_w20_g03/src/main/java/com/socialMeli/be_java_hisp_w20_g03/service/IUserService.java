package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserExtendedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowersDTO;

import java.util.List;


public interface IUserService {
    List<UserExtendedDTO> getUsers();
    String addFollower(int userId, int userIdToFollow);
    UserFollowerCountDTO getFollowerCount(int userId);
    UserFollowersDTO getFollowersList(int userId, String order);
    UserFollowedDTO getFollowedList(int userId, String order);
    String unfollow(int userId, int UserIdToUnfollow);
}
