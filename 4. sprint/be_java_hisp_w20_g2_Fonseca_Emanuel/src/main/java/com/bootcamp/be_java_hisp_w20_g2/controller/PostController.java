package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.PostPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostPromoCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowedResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;
    // US-0005
    @PostMapping(path = "/post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewProduct(@RequestBody PostDTO newPost) {
        postService.createPost(newPost);
    }
    // US-0006 - US-0009
    @GetMapping("followed/{userId}/list")
    public PostResponseDTO sendLastPostOfFollowed(@PathVariable int userId, @RequestParam Optional<String> order) {
        return postService.sendLastPostOfFollowed(userId,order);
    }
    // US-0010
    @PostMapping(path = "/promo-post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewPromoProduct(@RequestBody PostPromoDTO newPost){
        postService.createPromoPost(newPost);
    }
    // US-0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getCountProductPromo(@RequestParam Optional<Integer> user_id) {
        PostPromoCountResponseDTO postPromoCountResponseDTO = postService.countProductPromoOfUser(user_id);
        return new ResponseEntity<>(postPromoCountResponseDTO, HttpStatus.OK);
    }
}
