package com.bootcamp.be_java_hisp_w20_g4.service;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserFollowersDTO;

import java.util.List;

public interface IServiceUsr {

    public UserCountDTO followersCount(int userId);

    public UserFollowersDTO followers(int userId, String order);

    public UserFollowedDTO follow(int userId, int userIdToFollow);

    public UserFollowedDTO followed(int userId, String order);
    public UserFollowedDTO unfollow(int userId, int userIdToUnfollow);

}
