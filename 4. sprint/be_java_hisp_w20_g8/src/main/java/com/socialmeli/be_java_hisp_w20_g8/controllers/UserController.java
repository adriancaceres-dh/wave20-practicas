package com.socialmeli.be_java_hisp_w20_g8.controllers;


import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{userId}/followed/list")
    public UserFollowedDTO getFollowed(@PathVariable int userId) {
        return userService.getAllFollowed(userId);
    }

    @GetMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDto> newFollow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        try {
            return new ResponseEntity<>(userService.addNewFollow(userId, userIdToFollow), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new OperationFailedException(e.getMessage() + " Please check the information");
        }
    }

    @GetMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDto> unfollowC(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        try {
            return new ResponseEntity<>(userService.unfollow(userId, userIdToUnfollow), HttpStatus.OK);
        } catch (NumberFormatException e) {
            throw new OperationFailedException(e.getMessage() + " Please check the information");
        }
    }
}
