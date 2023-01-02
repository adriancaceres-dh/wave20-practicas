package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.*;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @GetMapping("/products/followed/{userId}/list")
    public FollowedUsersPostsResponse getFollowedUsersPosts(@PathVariable int userId,
                                                            @RequestParam(required = false) String order){
        return postService.getFollowedUsersPosts(userId, order);
    }
}
