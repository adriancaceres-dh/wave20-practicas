package com.socialMeli.be_java_hisp_w20_g03.controller;

import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserExtendedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService iUserService;


    @GetMapping("/users")
    public ResponseEntity<List<UserExtendedDTO>> list() {
        return new ResponseEntity<>(iUserService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> addFollower(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity<>(iUserService.addFollower(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDTO> getFollowerCount(@PathVariable int userId) {
        return new ResponseEntity<>(iUserService.getFollowerCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity <UserFollowersDTO> getFollowersList(@PathVariable int userId,
                                                              @RequestParam (required = false) String order) {
        return new ResponseEntity<>(iUserService.getFollowersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowedList(@PathVariable int userId,
                                                           @RequestParam (required = false) String order) {
        return new ResponseEntity<>(iUserService.getFollowedList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity<>(iUserService.unfollow(userId, userIdToUnfollow), HttpStatus.OK);
    }

}
