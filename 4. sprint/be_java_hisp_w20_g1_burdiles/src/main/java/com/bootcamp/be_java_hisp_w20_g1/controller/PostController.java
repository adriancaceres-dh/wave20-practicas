package com.bootcamp.be_java_hisp_w20_g1.controller;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostPromoRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/post")
    public ResponseEntity<PostResponseDto> addPost(@RequestBody PostRequestDto post) {
        return ResponseEntity.ok(postService.add(post));
    }
    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoResponseDto> addPostPromo(@RequestBody PostPromoRequestDto post) {
        return new ResponseEntity<>(postService.addPromo(post), HttpStatus.CREATED);
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountResponseDto> countPromoPost(@RequestParam int user_id) {
        return ResponseEntity.ok(postService.countPromoPost(user_id));
    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<PostPromoListByUserResponseDto> promoPostListByUser(@RequestParam int user_id) {
        return ResponseEntity.ok(postService.promoPostListByUser(user_id));
    }
}
