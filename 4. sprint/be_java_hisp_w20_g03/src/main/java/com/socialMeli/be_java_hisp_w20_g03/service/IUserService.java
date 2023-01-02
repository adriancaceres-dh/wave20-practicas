package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;


public interface IUserService {
    public boolean addFollower(int userId, int userIdToFollow);
    public UserFollowerCountDTO getFollowerCount(int userId);
    public UserFollowersDTO getFollowersList(int userId);
    public UserFollowersDTO getFollowedList(int userId, String order);
    public boolean unfollow(int userId, int UserIdToUnfollow);
}
