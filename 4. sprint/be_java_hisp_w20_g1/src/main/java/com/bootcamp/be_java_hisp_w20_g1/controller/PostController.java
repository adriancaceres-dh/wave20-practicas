package com.bootcamp.be_java_hisp_w20_g1.controller;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResponseDto> lastTwoWeeksPostsFromFollowers (@PathVariable int userId, @RequestParam String order) {
        return ResponseEntity.ok(postService.lastTwoWeeksPostsFromFollowers(userId, order));
    }
}
