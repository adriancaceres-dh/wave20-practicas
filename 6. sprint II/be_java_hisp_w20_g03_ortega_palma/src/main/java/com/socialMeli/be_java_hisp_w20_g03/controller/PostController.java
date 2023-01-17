package com.socialMeli.be_java_hisp_w20_g03.controller;

import com.socialMeli.be_java_hisp_w20_g03.dto.request.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private IPostService iPostService;

    @PostMapping("/products/post")
    public ResponseEntity<String> addPost(@RequestBody @Valid PostDTO postDto) {
        return new ResponseEntity<>(iPostService.addPost(postDto), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity <List<PostDTO>> getPosts(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iPostService.getPost(userId, order), HttpStatus.OK);
    }
}
