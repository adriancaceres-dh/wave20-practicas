package com.bootcamp.be_java_hisp_w20_g1.controller;


import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.service.UserService;
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


    private IUserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersResponseDto> getSellerFollowers(
            @PathVariable int userId,
            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(userService.getSellerFollowersDto(userId, order));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountResponseDto> getFollowersCount(@PathVariable int userId) {
        return ResponseEntity.ok().body(userService.getFollowersCountDto(userId));
    }


    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedResponseDto> getUserFollowed(
            @PathVariable int userId,
            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(userService.getFollowedDto(userId, order));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserFollowedResponseDto> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return ResponseEntity.ok(userService.followUser(userId, userIdToFollow));
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserFollowedResponseDto> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));

    }

}

