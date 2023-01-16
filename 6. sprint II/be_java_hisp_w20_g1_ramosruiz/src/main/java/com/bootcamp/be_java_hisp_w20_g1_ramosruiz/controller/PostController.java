package com.bootcamp.be_java_hisp_w20_g1_ramosruiz.controller;

import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.service.PostService;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.service.interfaces.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/products")
public class PostController {
    private IPostService postService;

    public PostController(PostService service) {
        this.postService = service;
    }


    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResponseDto> lastTwoWeeksPostsFromFollowers(@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(postService.lastTwoWeeksPostsFromFollowers(userId, order));
    }


    @PostMapping("/post")
    public ResponseEntity<PostResponseDto> addPost(@Valid @RequestBody PostRequestDto post) {
        return new ResponseEntity<>(postService.add(post), HttpStatus.CREATED);
    }
}
