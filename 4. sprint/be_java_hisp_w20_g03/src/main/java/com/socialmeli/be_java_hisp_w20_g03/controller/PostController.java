package com.socialmeli.be_java_hisp_w20_g03.controller;

import com.socialmeli.be_java_hisp_w20_g03.dto.*;
import com.socialmeli.be_java_hisp_w20_g03.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private IPostService iPostService;

    @PostMapping("/post")
    public ResponseEntity<String> addPost(@RequestBody PostDTO postDto) {
        return new ResponseEntity<>(iPostService.addPost(postDto), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<String> addPromoPost(@RequestBody PromoPostDTO postDto) {
        return new ResponseEntity<>(iPostService.addPost(postDto), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity <FavoritePostsListDTO> getPosts(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iPostService.getPost(userId, order), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromoCountDTO> getPromoPostCount(@RequestParam(name = "user_id") int userId) {
        return new ResponseEntity<>(iPostService.getPromoPostCount(userId), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerPromoListDTO> getPromoPostList(@RequestParam(name = "user_id") int userId) {
        return new ResponseEntity<>(iPostService.getPromoPostList(userId), HttpStatus.OK);
    }
}
