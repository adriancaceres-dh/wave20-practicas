package com.bootcamp.be_java_hisp_w20_g1.controller;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostPromoRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IPostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResponseDto> lastTwoWeeksPostsFromFollowers (@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(postService.lastTwoWeeksPostsFromFollowers(userId, order));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PostPromoListResponseDto> promoProductsByUserId (@RequestParam int userId){
        return ResponseEntity.ok(postService.promoProductsByUserId(userId));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<UserPromoPostsCountResponseDto> promoPostsCountByUser (@RequestParam int userId){
        return ResponseEntity.ok(postService.promoPostsCountByUser(userId));
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDto> addPost(@RequestBody PostRequestDto post) {

        return ResponseEntity.ok(postService.add(post));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoResponseDto> addPostWithPromo(@RequestBody PostPromoRequestDto post){
        return ResponseEntity.ok(postService.add(post));
    }
}
