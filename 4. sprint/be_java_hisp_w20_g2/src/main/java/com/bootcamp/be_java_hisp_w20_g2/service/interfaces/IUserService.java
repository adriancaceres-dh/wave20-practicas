package com.bootcamp.be_java_hisp_w20_g2.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;

public interface IUserService {

    UserFollowersResponseDTO findAllFollowers(int userId);

    void unfollowUser(int userId, int userIdToUnfollow);

    public boolean follow(Integer idFollower, Integer idFollowed);

    public UserFollowersCountResponseDTO followerList(Integer id);

}
