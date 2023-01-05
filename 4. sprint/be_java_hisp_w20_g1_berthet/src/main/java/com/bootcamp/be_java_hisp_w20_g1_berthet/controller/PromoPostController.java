package com.bootcamp.be_java_hisp_w20_g1_berthet.controller;

import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostPromoCounResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostListResponseDto;;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostPromoListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/products/promo-post")
public class PromoPostController {

    @Autowired
    private IPostService postService;

    @PostMapping
    public ResponseEntity<PromoPostRequestDto> addPromoPost(@RequestBody PromoPostRequestDto promoPost) {
        return ResponseEntity.ok(postService.addPromoPost(promoPost));
    }

    @GetMapping("/count")
    public ResponseEntity<PostPromoCounResponseDto> countPromoPosts(@RequestParam(name="user_id") int userId) {
        return ResponseEntity.ok(postService.countPromoPosts(userId));
    }

    @GetMapping("/list")
    public ResponseEntity<PostPromoListResponseDto> getPromoPosts(@RequestParam(name="user_id") int userId) {
        return ResponseEntity.ok(postService.getPromoPosts(userId));
    }
}
