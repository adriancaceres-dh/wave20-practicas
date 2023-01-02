package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IUserService;
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


    @PostMapping ("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {

        boolean followed = userService.followUser(userId, userIdToFollow);
        if (followed) {
            return new ResponseEntity<>("Se ha seguido correctamente.", HttpStatus.OK);
        } else return new ResponseEntity<>("No se ha seguido al usuario.", HttpStatus.BAD_REQUEST);

    }

    @PostMapping ("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        boolean unfollowed = userService.followUser(userId, userIdToUnfollow);
        if (unfollowed) {
            return new ResponseEntity<>("Se ha dejado de seguir correctamente.", HttpStatus.OK);
        } else return new ResponseEntity<>("Error al dejar de seguir al usuario.", HttpStatus.BAD_REQUEST);
    }
    @PostMapping ("/add")
    public ResponseEntity<String> addUsers(@RequestBody List<User> users){
        return new ResponseEntity<>(userService.addUsers(users),HttpStatus.OK);
    }

    @GetMapping ("/list")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

}
