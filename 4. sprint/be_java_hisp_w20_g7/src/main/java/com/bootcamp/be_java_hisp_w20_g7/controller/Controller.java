package com.bootcamp.be_java_hisp_w20_g7.controller;

import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersDto;
import com.bootcamp.be_java_hisp_w20_g7.service.IPostService;
import com.bootcamp.be_java_hisp_w20_g7.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    IUserService iUserService;

    @Autowired
    IPostService postService;

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserFollowersDto> findAllFollowers(
            @PathVariable int userId
    ) {
        UserFollowersDto userFollowersDto = iUserService.userFollowers(userId);

        return new ResponseEntity<>(userFollowersDto, HttpStatus.OK);
    }

    @PostMapping("/products/post")
    ResponseEntity<String> postAdd(@RequestBody PostCreateDto post) {
        if (post == null) {
            return new ResponseEntity<>("Esta vacio", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    //1) retorna String
    //7) retorna String
}
