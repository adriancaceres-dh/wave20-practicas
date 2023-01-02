package com.bootcamp.be_java_hisp_w20_g2.controller;


import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.service.UserService;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    public UserController(){

    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> getFollowersById(@PathVariable int userId) {
        UserFollowersResponseDTO userFollowersResponseDTO = userService.findAllFollowers(userId);
        return new ResponseEntity<>(userFollowersResponseDTO, HttpStatus.OK);
    }

}
