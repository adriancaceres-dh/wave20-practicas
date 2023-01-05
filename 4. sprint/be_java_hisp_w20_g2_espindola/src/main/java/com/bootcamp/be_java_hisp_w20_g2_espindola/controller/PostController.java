package com.bootcamp.be_java_hisp_w20_g2_espindola.controller;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.request.PostPromoRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostPromoCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.service.interfaces.IPostService;
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
    @ResponseStatus(HttpStatus.OK)
    public void addNewProduct(@RequestBody PostDTO newPost) {
        postService.createPost(newPost);
    }

    // US-0006 - US-0009
    @GetMapping("followed/{userId}/list")
    public PostResponseDTO sendLastPostOfFollowed(@PathVariable int userId, @RequestParam Optional<String> order) {
        return postService.sendLastPostOfFollowed(userId,order);
    }

    //US-0010
    @PostMapping(path="/promo-post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewProductPromo(@RequestBody PostPromoRequestDTO newPostPromo){
        postService.createPromoPost(newPostPromo);
    }

    //US-0011
    @GetMapping("/promo-post/count")
    public PostPromoCountResponseDTO getPromoPostCount(@RequestParam int user_id){
        return postService.countPromotionPosts(user_id);
    }
}
