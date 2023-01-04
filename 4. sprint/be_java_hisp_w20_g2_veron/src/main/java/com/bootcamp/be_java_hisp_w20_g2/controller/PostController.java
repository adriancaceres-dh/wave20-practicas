package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserPromoProductsCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IPostService;
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
        postService.createPost(newPost,false);
    }
    // US-0006 - US-0009
    @GetMapping("followed/{userId}/list")
    public PostResponseDTO sendLastPostOfFollowed(@PathVariable int userId, @RequestParam Optional<String> order) {
        return postService.sendLastPostOfFollowed(userId,order);
    }

    // US-0010
    @PostMapping(path = "/promo-post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewPromoProduct(@RequestBody PostDTO newPost) {
        postService.createPost(newPost,true);
    }

    // US-0011
    @GetMapping(path = "/promo-post/count")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserPromoProductsCountResponseDTO> getUserPromoProductsCount(@RequestParam int user_id ) {
        return ResponseEntity.ok(postService.getPromotionProductsQuantity(user_id));
    }
}
