package com.bootcamp.be_java_hisp_w20_g4.service;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserDTO;

public interface IServiceUsr {

    public UserCountDTO followersCount(int userId);

    public UserDTO followers(int userId);

}
