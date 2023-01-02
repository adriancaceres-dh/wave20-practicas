package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.model.User;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    public ResponseEntity<UserFollowedResponseDto> followUser(int userId, int userIdToFollow){

        if (userId == userIdToFollow || !userRepository.isValidId(userId) || !userRepository.isValidId(userIdToFollow) )
            throw new RuntimeException("Id invalido");

        if(!userRepository.isSeller(userIdToFollow)) {
            throw new RuntimeException("El usuario a seguir no es un vendedor");
        }

        User user = userRepository.getUserById(userId);

        userRepository.addFollowed(userId,userIdToFollow);
        userRepository.addFollower(userIdToFollow, userId);

        List<UserResponseDto> userFollowedList = new ArrayList<>();
        for (Integer userFollowedId : user.getFollowed() ){
            User userFollowed = userRepository.getUserById(userFollowedId);
            userFollowedList.add(new UserResponseDto(userFollowedId,userFollowed.getName()));
        }

        return ResponseEntity.ok(new UserFollowedResponseDto(user.getId(),user.getName(),userFollowedList));
    }

    public ResponseEntity<UserFollowedResponseDto> unfollowUser(int userId, int userIdToUnfollow){

        if (userId == userIdToUnfollow || !userRepository.isValidId(userId) || !userRepository.isValidId(userIdToUnfollow) )
            throw new RuntimeException("Id invalido");


        User user = userRepository.getUserById(userId);

        userRepository.removeFollowed(userId,userIdToUnfollow);
        userRepository.removeFollower(userIdToUnfollow, userId);

        System.out.println(userRepository.getUserById(userId) + " " + userRepository.getUserById(userIdToUnfollow));

        List<UserResponseDto> userFollowedList = new ArrayList<>();
        for (Integer userFollowedId : user.getFollowed() ){
            User userFollowed = userRepository.getUserById(userFollowedId);
            userFollowedList.add(new UserResponseDto(userFollowedId,userFollowed.getName()));
        }

        return ResponseEntity.ok(new UserFollowedResponseDto(user.getId(),user.getName(),userFollowedList));

    }
}
