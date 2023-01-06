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
    public ResponseEntity<ResponsePostDTO> findAllPostsByIdUser(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(postService.findSellersByIdUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> postPost(@RequestBody PostRequestDTO postRequestDTO) {
        postService.createPost(postRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body("The post was published");
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> savePromoPost(@RequestBody PostPromoDTO postPromoDTO) {
        boolean isSaved = postService.createPostPromo(postPromoDTO);
        if (isSaved) {
            return new ResponseEntity<>("The Post Promo has been created", HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoCountDTO> countPromos(@RequestParam int user_id) {
        return new ResponseEntity<PromoCountDTO>(postService.promosCount(user_id), HttpStatus.OK);
    }

    @GetMapping("promo-post/list")
    public ResponseEntity<PostPromoListDTO> promoList(@RequestParam int user_id) {
        return new ResponseEntity<PostPromoListDTO>(postService.postPromoList(user_id), HttpStatus.OK);
    }
}
