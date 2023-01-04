package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.controller;

import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.FollowedListResponseDto;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.FollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.FollowersListResponseDto;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    IUserService userService;
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Boolean> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountResponseDto> countFollowers (@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListResponseDto> listFollowers(@PathVariable int userId, @RequestParam (required = false) String order){
        return new ResponseEntity<>(userService.getFollowersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListResponseDto> listFollowed(@PathVariable int userId, @RequestParam (required = false) String order){
        return new ResponseEntity<>(userService.getFollowedList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Boolean> unFollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity<>(userService.unFollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

}
