package com.bootcamp.be_java_hisp_w20_ramosruiz.controller;

import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PromoPostListResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PromoPostCountResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.service.interfaces.IPostService;
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

    @PostMapping("/post")
    public ResponseEntity<PostResponseDto> addPost(@RequestBody PostRequestDto post) {
        return ResponseEntity.status(201).body(postService.add(post));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostResponseDto> addPromoPost(@RequestBody PromoPostRequestDto post) {
        return ResponseEntity.status(201).body(postService.addPromo(post));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountResponseDto> countPromoPost(@RequestParam int user_id) {
        return ResponseEntity.ok(postService.countPromoPost(user_id));
    }

    @GetMapping("promo-post/list")
    public ResponseEntity<PromoPostListResponseDto> listPromoPost(@RequestParam int user_id, @RequestParam(defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(postService.listPromoPostByUserId(user_id, order));
    }
}
