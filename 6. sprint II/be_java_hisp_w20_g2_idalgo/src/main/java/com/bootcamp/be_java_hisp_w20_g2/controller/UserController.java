package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowedResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import com.bootcamp.be_java_hisp_w20_g2.utils.validator.userResponse.UserResponseSorterConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private IUserService userService;

    // US-0001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity<>(
                userService.follow(userId, userIdToFollow) ? "User followed." : "An error has occurred.",
                HttpStatus.OK);
    }

    // US-0002
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountResponseDTO> countFollowers(@PathVariable int userId) {
        return new ResponseEntity<>(userService.followerList(userId), HttpStatus.OK);
    }

    // US-0003 - US-0009
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersResponseDTO> getFollowersById(@PathVariable int userId, @RequestParam @UserResponseSorterConstraint Optional<String> order) {
        UserFollowersResponseDTO userFollowersResponseDTO = userService.findAllFollowers(userId, order);
        return new ResponseEntity<>(userFollowersResponseDTO, HttpStatus.OK);
    }

    // US-0004 - US-0009
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedResponseDTO> getFollowedById(@PathVariable int userId, @RequestParam @UserResponseSorterConstraint Optional<String> order) {
        UserFollowedResponseDTO userFollowedResponseDTO = userService.findAllFollowed(userId, order);
        return new ResponseEntity<>(userFollowedResponseDTO, HttpStatus.OK);
    }

    // US-0007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok().body(userService.unfollowUser(userId, userIdToUnfollow));
    }
}
