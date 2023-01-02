package com.bootcamp.be_java_hisp_w20_g2.service;


import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(){

    }

    @Override
    public UserFollowersResponseDTO findAllFollowers(int userId) {
        User userFound = userRepository.findOne(userId);
        if(userFound == null) {
            throw new UserNotFoundException("User not found");
        } else {
            List<UserResponseDTO> followers = userFound.getFollowers().stream().map(user -> new UserResponseDTO(user.getId(), user.getUserName())).collect(Collectors.toList());
            //^^^^^^ podría hacerse con un mapper ^^^^^^
            return new UserFollowersResponseDTO(userFound.getId(), userFound.getUserName(), followers);
        }
    }

    public User findUser(int userIdFind){
        User userFind = userRepository.findOne(userIdFind);
        return userFind;
    }

    @Override
    public void saveUser(User user){
        userRepository.save(user);
    }

}
