package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowingUsersPostsResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoPostsListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserPostsCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<String> newPost(@RequestBody (required = false) PostRequestDTO postRequestDTO) {
        postService.newPost(postRequestDTO);
        return new ResponseEntity<>("La publicación ha sido realizada con éxito", HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<String> newPromoPost(@RequestBody PostRequestDTO postRequestDTO) {
        postService.newPost(postRequestDTO);
        return new ResponseEntity<>("La publicación ha sido realizada con éxito", HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowingUsersPostsResponseDTO> getFollowedUsersPosts(@PathVariable int userId,
                                                                @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.getFollowingUsersPosts(userId, order), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<UserPostsCountDTO> getPromoPostsCount(@RequestParam int user_id){
        return new ResponseEntity<>(postService.getPromoPostsCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostsListDTO> getPromoPostsList(@RequestParam int user_id){
        return new ResponseEntity<>(postService.getPromoPostsList(user_id), HttpStatus.OK);
    }
}
