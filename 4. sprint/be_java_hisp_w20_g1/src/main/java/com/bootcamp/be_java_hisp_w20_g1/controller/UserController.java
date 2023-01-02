package com.bootcamp.be_java_hisp_w20_g1.controller;


import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    //US 3
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersResponseDto> getSellerFollowers(
            @PathVariable int userId,
            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(userService.getSellerFollowersDto(userId, order));
    }

    //US 2
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountResponseDto> getFollowersCount(@PathVariable int userId) {
        return ResponseEntity.ok().body(userService.getFollowersCountDto(userId));
    }

    //us 4
    @GetMapping(value = "/{userId}/followed/list", params = {"order"})
    public ResponseEntity<UserFollowedResponseDto> getUserFollowed(
            @PathVariable int userId,
            @RequestParam(required = false) String order) {
        return ResponseEntity.ok().body(userService.getFollowedDto(userId, order));
    }


}
