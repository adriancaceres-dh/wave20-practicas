package com.bootcamp.be_java_hisp_w20_g4_pereyra.service.user;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserFollowersDTO;

public interface IServiceUsr {

    public UserCountDTO followersCount(int userId);

    public UserFollowersDTO followers(int userId, String order);

    public UserFollowedDTO follow(int userId, int userIdToFollow);

    public UserFollowedDTO followed(int userId, String order);
    public UserFollowedDTO unfollow(int userId, int userIdToUnfollow);

}
