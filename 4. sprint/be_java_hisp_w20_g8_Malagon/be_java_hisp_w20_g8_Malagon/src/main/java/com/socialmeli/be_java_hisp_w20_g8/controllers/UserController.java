package com.socialmeli.be_java_hisp_w20_g8.controllers;



import com.socialmeli.be_java_hisp_w20_g8.dto.UserAndFollowedsDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowed(@PathVariable int userId, @RequestParam(required = false) String order){
        return ResponseEntity.ok().body(userService.getAllFollowed(userId, order));
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDto> newFollow(@PathVariable int userId, @PathVariable int userIdToFollow){
            return new ResponseEntity<>(userService.addNewFollow(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDto> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
            return new ResponseEntity<>(userService.unfollow(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/count")
    public ResponseEntity<UserAndFollowedsDTO> getNumberOfFollowedSellers(@PathVariable int userId){
        return new ResponseEntity<>(userService.getCountFollowed(userId), HttpStatus.OK);
    }
}
