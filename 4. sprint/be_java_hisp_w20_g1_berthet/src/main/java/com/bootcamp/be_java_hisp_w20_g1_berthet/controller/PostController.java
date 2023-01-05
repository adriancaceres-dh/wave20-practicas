package com.bootcamp.be_java_hisp_w20_g1_berthet.controller;

import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResponseDto> lastTwoWeeksPostsFromFollowers (@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(postService.lastTwoWeeksPostsFromFollowers(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<PostRequestDto> addPost(@RequestBody PostRequestDto post) {
        postService.add(post);
        return ResponseEntity.ok(post);
    }
}
