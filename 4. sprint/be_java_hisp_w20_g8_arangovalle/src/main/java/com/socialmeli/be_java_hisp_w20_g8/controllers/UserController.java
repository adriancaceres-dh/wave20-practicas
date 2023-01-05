package com.socialmeli.be_java_hisp_w20_g8.controllers;



import com.socialmeli.be_java_hisp_w20_g8.dto.UserDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/{userId}/followed/list")
    public UserFollowedDTO getFollowed(@PathVariable int userId, @RequestParam(required = false) String order){
            return userService.getAllFollowed(userId, order);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDto> newFollow(@PathVariable int userId, @PathVariable int userIdToFollow){
            return new ResponseEntity<>(userService.addNewFollow(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDto> unfollowC(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
            return new ResponseEntity<>(userService.unfollow(userId, userIdToUnfollow), HttpStatus.OK);
    }
    @PostMapping("/newUser")
    public ResponseEntity<ResponseDto> newUser(@RequestBody UserDTO newUser){
        return new ResponseEntity<>(userService.newUser(newUser),HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> allUsers(){
        return new ResponseEntity<>(userService.allUsers(),HttpStatus.OK);
    }
}
