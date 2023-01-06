package com.socialMeli.be_java_hisp_w20_g03.controller;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.ProductDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.Request.PromoPostRequestDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.Response.PromoPostCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private IPostService iPostService;

    @PostMapping("/post")
    public ResponseEntity<String> addPost(@RequestBody PostDTO postDto) {
        return new ResponseEntity<>(iPostService.addPost(postDto), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity <List<PostDTO>> getPosts(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iPostService.getPost(userId, order), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<String> addPromoPost(@RequestBody PromoPostRequestDTO promoPostRequestDto) {
        return new ResponseEntity<>( iPostService.addPromoPost(promoPostRequestDto),HttpStatus.OK);
    }

    @GetMapping("promo-post/count")
    public ResponseEntity <PromoPostCountDTO> getPosts(@RequestParam int user_id) {
        return new ResponseEntity<>(iPostService.getPromoProducts(user_id), HttpStatus.OK);
    }
}
