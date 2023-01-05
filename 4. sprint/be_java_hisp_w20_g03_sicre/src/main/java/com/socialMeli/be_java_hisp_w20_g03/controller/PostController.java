package com.socialMeli.be_java_hisp_w20_g03.controller;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.PostDiscountCountDto;
import com.socialMeli.be_java_hisp_w20_g03.dto.PostDiscountDto;
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
    @PostMapping ("/products/promo-post")
    public ResponseEntity<String> addDiscountPost(@RequestBody PostDiscountDto postDiscountDto) {
        return new ResponseEntity<>(iPostService.addDiscountPost(postDiscountDto), HttpStatus.OK);
    }
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PostDiscountCountDto> getDiscountCountPost(@RequestParam int userId){
        return new ResponseEntity<>(iPostService.getDiscountCountPostByUserId(userId),HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<List<PostDiscountDto>> getDiscountPost(@RequestParam int userId){
        return new ResponseEntity<>(iPostService.getDiscountPostByUserId(userId),HttpStatus.OK);
    }
}
