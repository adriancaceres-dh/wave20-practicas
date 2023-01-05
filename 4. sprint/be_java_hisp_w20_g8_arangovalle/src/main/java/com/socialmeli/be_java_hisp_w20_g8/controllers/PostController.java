package com.socialmeli.be_java_hisp_w20_g8.controllers;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponsePostDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.repositories.posts.IPostRepository;
import com.socialmeli.be_java_hisp_w20_g8.services.posts.IPostService;
import com.socialmeli.be_java_hisp_w20_g8.services.posts.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private IPostService postService;

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

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> postPromoPost(@RequestBody PostRequestDTO postRequestDTO) {
        try {
            postService.createPostPromo(postRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body("The post was published");
        } catch(Exception e) {
            throw new OperationFailedException(e.getMessage() + " Please check the information");
        }
    }
}
