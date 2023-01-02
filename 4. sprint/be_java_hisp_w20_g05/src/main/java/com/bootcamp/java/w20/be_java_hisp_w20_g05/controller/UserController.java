package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
