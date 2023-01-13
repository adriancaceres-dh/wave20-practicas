package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersBySellerDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;


    @PostMapping ("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserResponseDTO> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity<>(userService.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping ("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserResponseDTO> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity<>(userService.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

    //Cuenta la cantidad de seguidores que tiene un determinado usuario buscándolo por su id. En caso de no encontrarlo devuelve una excepción IdNotFoundException.
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    //Retorna un dto con  los username y userid de los de los usuarios seguidos por un usuario según su id
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowedById(@PathVariable int userId,
                                                           @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowedListDto(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersBySellerDTO> getFollowersBySellerDto(@PathVariable int userId,
                                                                        @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.getFollowersBySeller(userId,order),HttpStatus.OK);
    }


}
