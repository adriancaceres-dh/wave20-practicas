package com.socialmeli.be_java_hisp_w20_g8.controllers;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponsePostDTO;
import com.socialmeli.be_java_hisp_w20_g8.services.posts.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;


@RestController
@RequestMapping("/products")
@Validated
public class PostController {

    @Autowired
    IPostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponsePostDTO> findAllPostsByIdUser(@Positive(message ="El ID deber ser mayor a cero")
        @PathVariable int userId, @RequestParam(required = false) String order){
            return new ResponseEntity<>(postService.findSellersByIdUser(userId,order), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> postPost(@Valid @RequestBody PostRequestDTO postRequestDTO) {
            ResponseDTO  response = postService.createPost(postRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
