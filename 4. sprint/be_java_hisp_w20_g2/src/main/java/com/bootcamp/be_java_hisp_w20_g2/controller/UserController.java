package com.bootcamp.be_java_hisp_w20_g2.controller;


import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Boolean> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersById(@PathVariable int userId) {
        UserFollowersResponseDTO userFollowersResponseDTO = userService.findAllFollowers(userId);
        return new ResponseEntity<>(userFollowersResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserResponseDTO> countFollowers(@PathVariable int userId) {
        return new ResponseEntity<>(userService.followerList(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> postUnfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        userService.unfollowUser(userId, userIdToUnfollow);
        return ResponseEntity.ok().body("Operación exitosa");
    }

}
