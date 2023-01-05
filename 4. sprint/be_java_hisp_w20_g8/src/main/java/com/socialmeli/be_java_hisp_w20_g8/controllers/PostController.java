package com.socialmeli.be_java_hisp_w20_g8.controllers;

import com.socialmeli.be_java_hisp_w20_g8.dto.request.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.response.ProductsPromoCountDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.response.ResponsePostDTO;
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
        } catch (Exception e) {
            throw new OperationFailedException(e.getMessage() + " Please check the information");
        }
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<ProductsPromoCountDTO> countFollowers(@RequestParam(required = false) int user_id){
        return ResponseEntity.ok().body(postService.countProductsPromo(user_id));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<ResponsePostDTO> findAllProductsPromoByIdUser(@RequestParam(required = false) int user_id){
        return ResponseEntity.ok().body(postService.findAllProductsPromoByIdUser(user_id));
    }

}
