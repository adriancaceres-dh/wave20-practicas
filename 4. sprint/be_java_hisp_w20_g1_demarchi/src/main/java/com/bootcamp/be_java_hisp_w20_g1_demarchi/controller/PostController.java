package com.bootcamp.be_java_hisp_w20_g1_demarchi.controller;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.PostPromoRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.PostPromoListCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.PostPromoResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.service.interfaces.IPostService;
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
        return ResponseEntity.ok(postService.add(post));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoResponseDto> addPromotionPost(@RequestBody PostPromoRequestDto postPromoRequestDto) {
        return ResponseEntity.ok().body(postService.add(postPromoRequestDto));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoListCountResponseDto> getAmountOfProductsOnPromotionBySeller(
            @RequestParam int userId
    ) {
        return ResponseEntity.ok().body(postService.getAmountOfPostsOnPromotion(userId));
    }
}
