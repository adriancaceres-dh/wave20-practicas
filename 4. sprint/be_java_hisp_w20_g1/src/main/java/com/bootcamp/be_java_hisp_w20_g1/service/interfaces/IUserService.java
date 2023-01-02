package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;

public interface IUserService {

    UserFollowersResponseDto getSellerFollowers(int id);
    UserFollowersCountResponseDto getFollowersCount(int id);
}
