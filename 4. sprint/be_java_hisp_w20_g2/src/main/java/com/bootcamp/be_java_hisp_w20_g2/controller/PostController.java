package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping(path = "/post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewProduct(@RequestBody PostRequestDTO newPost){
        postService.createPost(newPost);
    }
}
