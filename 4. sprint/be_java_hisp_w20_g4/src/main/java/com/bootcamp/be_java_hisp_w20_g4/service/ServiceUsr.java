package com.bootcamp.be_java_hisp_w20_g4.service;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w20_g4.repository.IPublicationRepository;
import com.bootcamp.be_java_hisp_w20_g4.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsr implements IServiceUsr {

    @Autowired
    IUserRepository userRepository;

    public UserCountDTO followersCount(int userId){
        return null;
    }

    public UserDTO followers(int userId){
        return null;
    }



}
