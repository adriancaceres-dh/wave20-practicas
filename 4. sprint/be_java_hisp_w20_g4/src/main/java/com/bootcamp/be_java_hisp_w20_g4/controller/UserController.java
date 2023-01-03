package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserFollowersDTO;
import com.bootcamp.be_java_hisp_w20_g4.service.IServicePublication;
import com.bootcamp.be_java_hisp_w20_g4.service.IServiceUsr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    IServicePublication publicationService;

    @Autowired
    IServiceUsr usrService;



    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserDTO> follow(@PathVariable int userId , @PathVariable int userIdToFollow){
        return ResponseEntity.ok().body(usrService.follow(userId, userIdToFollow));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserCountDTO> followersCount(@PathVariable int userId){
        return ResponseEntity.ok().body(usrService.followersCount(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> followers(@PathVariable int userId , @RequestParam(value="order",required = false) String order){
        return ResponseEntity.ok().body(usrService.followers(userId, order));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> followed(@PathVariable int userId , @RequestParam(value="order",required = false) String order){
        return ResponseEntity.ok().body(usrService.followed(userId, order));
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable int userId , @PathVariable int userIdToUnfollow){
        return ResponseEntity.ok().body("Response del service");
    }


}
