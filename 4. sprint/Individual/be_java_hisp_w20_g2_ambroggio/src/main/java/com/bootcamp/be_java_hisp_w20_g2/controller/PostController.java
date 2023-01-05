package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.PostPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostPromoCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserProductsPromoResponseDTO;
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

    @PostMapping(path = "/promo-post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewProductPromo(@RequestBody PostPromoDTO newPost) {
        postService.createPostPromo(newPost);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountResponseDTO> countsProductsPromo(@RequestParam int user_id){
        return new ResponseEntity<>(postService.countsProductsPromo(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<UserProductsPromoResponseDTO> listUserProductsPromo(@RequestParam int user_id){
        return new ResponseEntity<>(postService.listUserProductsPromo(user_id), HttpStatus.OK);
    }

}
