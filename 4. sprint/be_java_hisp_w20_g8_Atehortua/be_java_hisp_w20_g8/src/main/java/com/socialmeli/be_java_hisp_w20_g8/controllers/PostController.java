package com.socialmeli.be_java_hisp_w20_g8.controllers;

import com.socialmeli.be_java_hisp_w20_g8.dto.*;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.services.posts.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponsePostDTO> findAllPostsByIdUser(@PathVariable int userId,  @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.findSellersByIdUser(userId,order), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<?> postPost(@RequestBody PostRequestDTO postRequestDTO) {
        try {
            postService.createPost(postRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body("The post was published");
        } catch(Exception e) {
            throw new OperationFailedException(e.getMessage() + " Please check the information");
        }
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> promoPost(@RequestBody PromoRequestDTO promoRequestDTO) {
        postService.createPostPromo(promoRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body("The promo-post was published");
    }

    @GetMapping("/promo-post/count/{userId}")
    public ResponseEntity<SellerCountPromoDTO> countProductProm(@PathVariable int userId){
        return ResponseEntity.ok().body(postService.sellerCountPromoProduct(userId));
    }

    @GetMapping("/promo-post/list/{userId}")
    public ResponseEntity<BonusDTO> promoProducts(@PathVariable int userId){
        return ResponseEntity.ok().body(postService.promoProducts(userId));
    }
}
