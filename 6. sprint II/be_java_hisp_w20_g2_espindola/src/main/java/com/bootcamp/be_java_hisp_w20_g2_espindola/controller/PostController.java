package com.bootcamp.be_java_hisp_w20_g2_espindola.controller;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g2_espindola.utils.validator.post.PostSorterConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Validated
public class PostController {
    @Autowired
    private IPostService postService;

    // US-0005
    @PostMapping(path = "/post")
    public ResponseEntity<PostDTO> addNewProduct(@RequestBody @Valid PostDTO newPost) {
        return new ResponseEntity<>(postService.createPost(newPost),HttpStatus.CREATED);
    }

    // US-0006 - US-0009
    @GetMapping("followed/{userId}/list")
    public PostResponseDTO sendLastPostOfFollowed(@PathVariable int userId, @PostSorterConstraint @RequestParam Optional<String> order) {
        return postService.sendLastPostOfFollowed(userId, order);
    }
}
