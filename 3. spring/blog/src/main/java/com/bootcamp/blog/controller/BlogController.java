package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.request.BlogPostRequestDto;
import com.bootcamp.blog.dto.response.BlogPostResponseDto;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> addPost(@RequestBody BlogPostRequestDto blogPostRequestDto) {
        return ResponseEntity.ok().body(blogService.addPost(blogPostRequestDto));
    }

    @GetMapping("blog/{id}")
    public ResponseEntity<BlogPostResponseDto> getPost(@PathVariable String id){
        return ResponseEntity.ok().body(blogService.getPost(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogPostResponseDto>> getPosts(){
        return ResponseEntity.ok().body(blogService.getPosts());
    }

}
