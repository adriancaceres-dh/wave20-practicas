package com.bootcamp.be_java_hisp_w20_g1.controller;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PromoPostCountDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PromoPostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.interfaces.BasePostDto;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    public ResponseEntity<PromoPostResponseDto> addPromoPost(@RequestBody PromoPostRequestDto post) {
        return ResponseEntity.ok(postService.addPromoPost(post));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDto> getPromoPosts(@RequestParam(defaultValue = "user") int user_id) {
        return ResponseEntity.ok((PromoPostCountDto) postService.getSellerPromoProducts(user_id, false, Optional.empty()).get(0));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<List<BasePostDto>> getListPromoPosts(@RequestParam(defaultValue = "user") int user_id, @RequestParam(defaultValue = "name_asc") String order) {
        return ResponseEntity.ok(postService.getSellerPromoProducts(user_id, true, Optional.of(order)));
    }

    @PatchMapping("/post/modify")
    public ResponseEntity<PromoPostResponseDto> modifyPost(@RequestBody PromoPostRequestDto post) {
        return ResponseEntity.ok(postService.modifyPost(post));
    }
}
