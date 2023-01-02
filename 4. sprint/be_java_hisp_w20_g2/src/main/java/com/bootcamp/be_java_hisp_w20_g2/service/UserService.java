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
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(){

    }

    @Override
    public UserFollowersResponseDTO findAllFollowers(int userId) {
        User userFound = userRepository.findUserById(userId);
        if(userFound == null) {
            throw new UserNotFoundException("No se ha encontrado el usuario");
        } else {
            List<UserResponseDTO> followers = userFound.getFollowers().stream().map(user -> new UserResponseDTO(user.getUserId(), user.getUserName())).collect(Collectors.toList());
            //^^^^^^ podría hacerse con un mapper ^^^^^^
            return new UserFollowersResponseDTO(userFound.getUserId(), userFound.getUserName(), followers);
        }
    }

}
