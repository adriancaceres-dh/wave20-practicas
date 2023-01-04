package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostWithDiscountRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserProductDiscountCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserProductDiscountListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.*;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping("/post")
    public ResponseEntity newPost(@RequestBody (required = false) PostRequestDTO postRequestDTO) {
        postService.newPost(postRequestDTO);
        return new ResponseEntity("todo OK",HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    public FollowedUsersPostsResponse getFollowedUsersPosts(@PathVariable int userId,
                                                            @RequestParam(required = false) String order){
        return postService.getFollowedUsersPosts(userId, order);
    }
    @PostMapping("/promo-post")
    public ResponseEntity newPostWithDiscount(@RequestBody (required = false) PostWithDiscountRequestDTO postWithDiscountRequestDTO){
        postService.newPostWithDiscount(postWithDiscountRequestDTO);
        return new ResponseEntity("todo OK", HttpStatus.OK);
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<UserProductDiscountCountDTO> getDiscountedUserProducts(@RequestParam Integer user_id) {
        return new ResponseEntity<>(postService.getDiscountUserProducts(user_id), HttpStatus.OK);
    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<UserProductDiscountListDTO> getDiscountedUserProductList(@RequestParam Integer user_id){
        return new ResponseEntity<UserProductDiscountListDTO>(postService.getDiscountedUserProductList(user_id), HttpStatus.OK);
    }
}
