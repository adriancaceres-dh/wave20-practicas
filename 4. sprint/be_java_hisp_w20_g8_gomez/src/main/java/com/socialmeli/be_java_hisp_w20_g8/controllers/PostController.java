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
    public ResponseEntity<String> postPost(@RequestBody PostRequestDTO postRequestDTO) {
            postService.createPost(postRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body("The post was published");
    }
    @PostMapping("/promo-post")
    public ResponseEntity<?> postPromoPost(@RequestBody PromoPostRequestDTO promoPostRequestDTO) {
        try{

            postService.createPromoPost(promoPostRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body("The post was published");
        }catch(Exception e) {
            throw new OperationFailedException(e.getMessage() + " Please check the information");
        }
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> countPromoPost(@RequestParam int user_id) {
        return ResponseEntity.ok().body(postService.promoPostCount(user_id));
    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListDTO> listPromoPost(@RequestParam int user_id) {
        return ResponseEntity.ok().body(postService.listPromoPostCount(user_id));
    }
}
