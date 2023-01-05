package com.socialmeli.be_java_hisp_w20_g8.controllers;

import com.socialmeli.be_java_hisp_w20_g8.dto.*;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.services.posts.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    IPostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponsePostDTO> findAllPostsByIdUser(@PathVariable int userId,  @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.findSellersByIdUser(userId,order), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<?> postPost(@RequestBody PostRequestDTO postRequestDTO) {
        postService.createPost(postRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body("The post was published");
    }

    @PostMapping("/promo-post")
    public ResponseEntity<String> postPromoPost(@RequestBody PromoPostRequestDTO promoPostRequestDTO) {
        postService.createPost(promoPostRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body("The promo post was published");
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCountByUserId(@RequestParam int user_id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPromoPostCountByUserId(user_id));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerPromoPostsResponseDTO> getPromoPostsBySellerId(@RequestParam int user_id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPromoPostsByUserId(user_id));
    }
}
