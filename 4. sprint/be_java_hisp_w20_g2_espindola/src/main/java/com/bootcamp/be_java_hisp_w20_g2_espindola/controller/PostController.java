package com.bootcamp.be_java_hisp_w20_g2_espindola.controller;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.request.PostPromoRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostPromoCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostPromoListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.service.interfaces.IPostService;
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
    public ResponseEntity<?> sendLastPostOfFollowed(@PathVariable int userId, @RequestParam Optional<String> order) {
        return new ResponseEntity<>(postService.sendLastPostOfFollowed(userId,order), HttpStatus.OK);
    }

    //US-0010
    @PostMapping(path="/promo-post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewProductPromo(@RequestBody PostPromoRequestDTO newPostPromo) {
        postService.createPromoPost(newPostPromo);
    }

    //US-0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.countPromotionPosts(user_id), HttpStatus.OK);
    }

    //US-0012
    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromoPostList(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.listPromotionPosts(user_id), HttpStatus.OK);
    }

}
