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
    public ResponseEntity<String> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {

        boolean followed = userService.followUser(userId, userIdToFollow);
        if (followed) {
            return new ResponseEntity<>("Se ha seguido correctamente.", HttpStatus.OK);
        } else return new ResponseEntity<>("No se ha seguido al usuario.", HttpStatus.BAD_REQUEST);

    }

    @PostMapping ("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        boolean unfollowed = userService.unfollowUser(userId, userIdToUnfollow);
        if (unfollowed) {
            return new ResponseEntity<>("Se ha dejado de seguir correctamente.", HttpStatus.OK);
        } else return new ResponseEntity<>("Error al dejar de seguir al usuario.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

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
