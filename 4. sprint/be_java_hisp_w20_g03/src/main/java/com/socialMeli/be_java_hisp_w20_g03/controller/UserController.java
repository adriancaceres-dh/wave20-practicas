package com.socialMeli.be_java_hisp_w20_g03.controller;

import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> addFollower(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return null;
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDTO> getFollowerCount(@PathVariable int userId) {
        return null;
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity <UserFollowersDTO> getFollowersList(@PathVariable String userId) {
        return null;
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowersDTO> getFollowedList(@PathVariable int userId) {
        return null;
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return null;
    }

}
