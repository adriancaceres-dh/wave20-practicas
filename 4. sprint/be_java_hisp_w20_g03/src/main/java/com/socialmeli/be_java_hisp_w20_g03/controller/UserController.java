package com.socialmeli.be_java_hisp_w20_g03.controller;

import com.socialmeli.be_java_hisp_w20_g03.dto.UserExtendedDTO;
import com.socialmeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialmeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;
import com.socialmeli.be_java_hisp_w20_g03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;


    @GetMapping("")
    public ResponseEntity<List<UserExtendedDTO>> list() {
        return new ResponseEntity<>(iUserService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> addFollower(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity<>(iUserService.addFollower(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDTO> getFollowerCount(@PathVariable int userId) {
        return new ResponseEntity<>(iUserService.getFollowerCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity <UserFollowersDTO> getFollowersList(@PathVariable int userId,
                                                              @RequestParam (required = false) String order) {
        return new ResponseEntity<>(iUserService.getFollowersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowersDTO> getFollowedList(@PathVariable int userId,
                                                            @RequestParam (required = false) String order) {
        return new ResponseEntity<>(iUserService.getFollowedList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity<>(iUserService.unfollow(userId, userIdToUnfollow), HttpStatus.OK);
    }

}
