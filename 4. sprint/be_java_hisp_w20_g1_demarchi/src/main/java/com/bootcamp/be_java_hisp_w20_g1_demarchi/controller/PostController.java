package com.bootcamp.be_java_hisp_w20_g1_demarchi.controller;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.PostPromoRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.pojo.PostFilter;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.service.interfaces.IPostService;
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
    public ResponseEntity<PostListResponseDto> lastTwoWeeksPostsFromFollowers(@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(postService.lastTwoWeeksPostsFromFollowers(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDto> addPost(@RequestBody PostRequestDto post) {
        return new ResponseEntity<>(postService.add(post), HttpStatus.CREATED);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoResponseDto> addPromotionPost(@RequestBody PostPromoRequestDto postPromoRequestDto) {
        return new ResponseEntity<>(postService.add(postPromoRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoListCountResponseDto> getAmountOfProductsOnPromotionBySeller(
            @RequestParam int userId
    ) {
        return ResponseEntity.ok().body(postService.getAmountOfPostsOnPromotion(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerWithProductsOnPromoListResponseDto> getListOfProductsOnPromotionBySeller(
        @RequestParam int userId,
        @RequestParam (required = false, defaultValue = "0.0") double minPrice,
        @RequestParam (required = false, defaultValue = "0.0") double maxPrice,
        @RequestParam (required = false, defaultValue = "0.0") double minDiscount,
        @RequestParam (required = false, defaultValue = "-1") int category
    ) {
        return ResponseEntity.ok().body(postService.getProductsOnPromotionByUser(
                userId,
                new PostFilter(minPrice, maxPrice, minDiscount, category)
                )
        );
    }
}
