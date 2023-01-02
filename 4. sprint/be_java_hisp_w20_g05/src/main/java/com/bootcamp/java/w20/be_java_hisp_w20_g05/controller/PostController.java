package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IPostService;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IService;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<Post> newPost(@RequestBody PostRequestDTO postRequestDTO){
        return new ResponseEntity<>(postService.newPost(postRequestDTO), HttpStatus.OK);
    }
}
