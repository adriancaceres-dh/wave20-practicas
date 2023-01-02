package com.bootcamp.be_java_hisp_w20_g7.controller;

import com.bootcamp.be_java_hisp_w20_g7.service.IFollowService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class FollowController {

    @Autowired
    IFollowService followService;

    @PostMapping("users/{userId}/follow/{userIdToFollow}")
    ResponseEntity<String> follow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return ResponseEntity.ok(followService.follow(userId, userIdToFollow));
    }

}
