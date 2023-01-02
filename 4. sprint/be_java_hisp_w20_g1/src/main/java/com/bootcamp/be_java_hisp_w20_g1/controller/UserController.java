package com.bootcamp.be_java_hisp_w20_g1.controller;


import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;


    @PostMapping("/{userId}/follow/{userIdToFollow}")

    public ResponseEntity<UserFollowedResponseDto> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
        return userService.followUser(userId,userIdToFollow);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserFollowedResponseDto> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return userService.unfollowUser(userId,userIdToUnfollow);


}
    }
