package com.bootcamp.be_java_hisp_w20_g4_pereyra.controller;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserFollowersDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.service.user.IServiceUsr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    IServiceUsr usrService;


    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserFollowedDTO> follow(@PathVariable int userId , @PathVariable int userIdToFollow){
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

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserFollowedDTO> unfollow(@PathVariable int userId , @PathVariable int userIdToUnfollow){
        return ResponseEntity.ok().body(usrService.unfollow(userId, userIdToUnfollow));
    }


}
