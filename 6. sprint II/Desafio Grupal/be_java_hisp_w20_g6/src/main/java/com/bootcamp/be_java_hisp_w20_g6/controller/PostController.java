package com.bootcamp.be_java_hisp_w20_g6.controller;

import com.bootcamp.be_java_hisp_w20_g6.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6.service.Interface.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("products")
public class PostController {
    
    @Autowired
    private IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<Boolean> save(@RequestBody @Valid PostRequestDto requestDto) {
        return new ResponseEntity<>(postService.save(requestDto), HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResponseDTO> getPost(@PathVariable @NotNull Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(postService.postFollowedLastWeeks(userId, order), HttpStatus.OK); 
    }
}
