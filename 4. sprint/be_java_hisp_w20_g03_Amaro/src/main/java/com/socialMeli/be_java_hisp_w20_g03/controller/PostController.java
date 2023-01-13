package com.socialMeli.be_java_hisp_w20_g03.controller;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.PromoPostCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.PromoPostDTO;
import com.socialMeli.be_java_hisp_w20_g03.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private IPostService iPostService;

    @PostMapping("/products/post")
    public ResponseEntity<String> addPost(@RequestBody PostDTO postDto) {
        return new ResponseEntity<>(iPostService.addPost(postDto), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity <List<PostDTO>> getPosts(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iPostService.getPost(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<String> addPromoPost(@RequestBody PromoPostDTO promoPostDto) {
        return new ResponseEntity<>(iPostService.addPromoPost(promoPostDto), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPostPromoCountByUser(@RequestParam int userId) {
        return new ResponseEntity<>(iPostService.getPromoPostCountById(userId), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<List<PromoPostDTO>> getPostPromoByUser(@RequestParam int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iPostService.getPromoPostById(userId, order), HttpStatus.OK);
    }
}
