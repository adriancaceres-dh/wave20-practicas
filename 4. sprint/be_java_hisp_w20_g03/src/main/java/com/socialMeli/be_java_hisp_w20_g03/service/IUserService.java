package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;

import java.util.List;

public interface IUserService {
    public boolean addFollower(int userId, int userIdToFollow);
    public UserFollowerCountDTO getFollowerCount(int userId);
    public List<UserFollowersDTO> getFollowersList(int userId);
    public List<UserFollowersDTO> getFollowedList(int userId);
    public boolean unfollow(int userId, int UserIdToUnfollow);
}
