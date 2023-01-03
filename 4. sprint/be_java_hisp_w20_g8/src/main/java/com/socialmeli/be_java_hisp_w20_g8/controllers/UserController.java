package com.socialmeli.be_java_hisp_w20_g8.controllers;


import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;
import com.socialmeli.be_java_hisp_w20_g8.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/{userId}/followed/list")
    public UserFollowedDTO getFollowed(@PathVariable int userId){
            return userService.getAllFollowed(userId);
    }

    @GetMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDto> newFollow(@PathVariable int userId, @PathVariable int sellerId){
        try{
            return new ResponseEntity<>(userService.addNewFollow(userId, sellerId), HttpStatus.OK);
        }
        catch (NumberFormatException e){
            throw  new OperationFailedException(e.getMessage() + " Please check the information");
        }
    }
}
