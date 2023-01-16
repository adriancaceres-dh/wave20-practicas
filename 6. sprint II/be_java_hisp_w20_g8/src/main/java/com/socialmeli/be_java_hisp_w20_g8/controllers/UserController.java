package com.socialmeli.be_java_hisp_w20_g8.controllers;



import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import com.socialmeli.be_java_hisp_w20_g8.services.users.IUserService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(
       @PathVariable @Positive(message = "El id debe ser mayor a cero") int userId, @RequestParam(required = false) String order){
        return ResponseEntity.ok().body(userService.getAllFollowed(userId, order));
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> newFollow(
            @PathVariable @Positive(message = "El id debe ser mayor a cero")int userId,
            @PathVariable @Positive(message = "El id debe ser mayor a cero")int userIdToFollow){
            return new ResponseEntity<>(userService.addNewFollow(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDTO> unfollow(
        @PathVariable @Positive(message = "El id debe ser mayor a cero") int userId,
        @PathVariable @Positive(message = "El id debe ser mayor a cero") int userIdToUnfollow) {
            return new ResponseEntity<>(userService.unfollow(userId, userIdToUnfollow), HttpStatus.OK);
    }
}
