package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

<<<<<<< Updated upstream
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
=======
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.GetFollowersBySellerDto;
>>>>>>> Stashed changes
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

=======
import org.springframework.web.bind.annotation.*;
>>>>>>> Stashed changes

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

<<<<<<< Updated upstream

    @PostMapping ("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {

        boolean followed = userService.followUser(userId, userIdToFollow);
        if (followed) {
            return new ResponseEntity<>("Se ha seguido correctamente.", HttpStatus.OK);
        } else return new ResponseEntity<>("No se ha seguido al usuario.", HttpStatus.BAD_REQUEST);

    }

    @PostMapping ("/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        userService.followUser(userId, userIdToUnfollow);
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
=======
    @GetMapping("/{userId}/followers/list")
    public GetFollowersBySellerDto getFollowersBySellerDto(@PathVariable int userId)
    {
        return userService.getFollowersBySeller(userId);
>>>>>>> Stashed changes
    }

}
