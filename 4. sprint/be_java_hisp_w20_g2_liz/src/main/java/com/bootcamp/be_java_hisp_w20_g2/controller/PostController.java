package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PromoPostCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PromoPostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;
    // US-0005
    @PostMapping(path = "/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewProduct(@RequestBody PostDTO newPost) {
        postService.createPost(newPost);
    }
    // US-0006 - US-0009
    @GetMapping("followed/{userId}/list")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDTO sendLastPostOfFollowed(@PathVariable int userId, @RequestParam Optional<String> order) {
        return postService.sendLastPostOfFollowed(userId,order);
    }
    // US-0010
    @PostMapping("/promo-post")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewPromoPost(@RequestBody PromoPostRequestDTO promoPostRequestDTO) {
        postService.createPromoPost(promoPostRequestDTO);
    }
    // US-0011
    @GetMapping("/promo-post/count")
    @ResponseStatus(HttpStatus.OK)
    public PromoPostCountResponseDTO countPromoPostsById(@RequestParam int user_id) {
        return postService.getPromoPostCount(user_id);
    }
    // US-0012
    @GetMapping("/promo-post/list")
    @ResponseStatus(HttpStatus.OK)
    public PromoPostListResponseDTO listPromoPostsById(@RequestParam int user_id) {
        return postService.getPromoPostList(user_id);
    }

}
