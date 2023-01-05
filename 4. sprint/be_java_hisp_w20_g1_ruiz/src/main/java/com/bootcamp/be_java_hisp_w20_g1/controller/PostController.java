package com.bootcamp.be_java_hisp_w20_g1.controller;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostPromoCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostPromoListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
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

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountResponseDto> promoPostCountByUser(@RequestParam(name = "user_id") int userId) {
        return ResponseEntity.ok(postService.promoPostCountByUser(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PostListResponseDto> promoPostListByUser(@RequestParam(name = "user_id") int userId) {
        return ResponseEntity.ok(postService.promoPostListByUser(userId));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResponseDto> lastTwoWeeksPostsFromFollowers (@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(postService.lastTwoWeeksPostsFromFollowers(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<PostRequestDto> addPost(@RequestBody PostRequestDto post) {
        postService.add(post, false);
        return new ResponseEntity<>(post,HttpStatus.CREATED);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostRequestDto> addPromoPost(@RequestBody PostRequestDto post) {
        postService.add(post, true);
        return new ResponseEntity<>(post,HttpStatus.CREATED);
    }
}
