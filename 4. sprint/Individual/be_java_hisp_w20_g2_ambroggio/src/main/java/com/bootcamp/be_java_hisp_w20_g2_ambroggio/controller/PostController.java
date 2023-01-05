package com.bootcamp.be_java_hisp_w20_g2_ambroggio.controller;

import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.PostPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.response.PostPromoCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.response.UserProductsPromoResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.service.interfaces.IPostService;
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
    public boolean addNewProductPromo(@RequestBody PostPromoDTO newPost) {
        return postService.createPostPromo(newPost);
    }
    //US-0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountResponseDTO> countsProductsPromo(@RequestParam int user_id){
        return new ResponseEntity<>(postService.countsProductsPromo(user_id), HttpStatus.OK);
    }
    //US-0012
    @GetMapping("/promo-post/list")
    public ResponseEntity<UserProductsPromoResponseDTO> listUserProductsPromo(@RequestParam int user_id){
        return new ResponseEntity<>(postService.listUserProductsPromo(user_id), HttpStatus.OK);
    }

}
