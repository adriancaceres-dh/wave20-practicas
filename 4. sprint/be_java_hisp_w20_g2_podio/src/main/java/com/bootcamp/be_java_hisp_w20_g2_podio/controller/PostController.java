package com.bootcamp.be_java_hisp_w20_g2_podio.controller;

import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.PromoPostCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.PromoPostListByUserIdResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    // US-0005
    @PostMapping(path = "/post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewProduct(@RequestBody PostDTO newPost) {
        postService.createPost(newPost);
    }

    // US-0006 - US-0009
    @GetMapping("followed/{userId}/list")
    public PostResponseDTO sendLastPostOfFollowed(@PathVariable int userId, @RequestParam Optional<String> order) {
        return postService.sendLastPostOfFollowed(userId,order);
    }

    // US-0010
    @PostMapping("/promo-post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewPromoPost(@RequestBody PromoPostDTO promoPost) {
        postService.createPromoPost(promoPost);
    }

    // US-0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountResponseDTO> getPromoPostsCount(@RequestParam int userId) {
        return ResponseEntity.ok().body(postService.getPromoProductsCountByUserId(userId));
    }

    // US-0012
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListByUserIdResponseDTO> getPromoPostListByUserId(@RequestParam int userId) {
        return ResponseEntity.ok().body(postService.getPromoPostListByUserId(userId));
    }
}
