package com.bootcamp.be_java_hisp_w20_g2.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;

public interface IUserService {

    public UserFollowersResponseDTO findAllFollowers(int userId);


}
