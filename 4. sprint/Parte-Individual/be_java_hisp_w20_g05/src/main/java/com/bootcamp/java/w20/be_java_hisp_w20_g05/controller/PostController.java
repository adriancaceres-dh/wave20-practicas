package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostPromoRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoPostBySellerDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.*;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
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

import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping("/post")
    public ResponseEntity newPost(@RequestBody PostRequestDTO postRequestDTO) {
        postService.newPost(postRequestDTO);
        return new ResponseEntity("todo OK",HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public FollowedUsersPostsResponse getFollowedUsersPosts(@PathVariable int userId,
                                                            @RequestParam(required = false) String order){
        return postService.getFollowedUsersPosts(userId, order);
    }

    //US OO11 -> crea un post que tiene una promocion.
    @PostMapping("/promo-post")
    public ResponseEntity newPromoPost(@RequestBody PostPromoRequestDTO postPromoRequestDTO) {
        postService.newPostPromo(postPromoRequestDTO);
        return new ResponseEntity("Promo creada OK",HttpStatus.OK);
    }

    //US 0012 -> obtiene la cantidad de productos en promocion de un determinado vendedor.
    @GetMapping("/promo-post/count")
    public PromoPostBySellerDTO CountPromoPostBySeller(@RequestParam int user_id)
    {
        return postService.getPromoPostbySeller(user_id);
    }

}
