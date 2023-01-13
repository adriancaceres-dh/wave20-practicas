package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PromoPostRequest;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_posts.PromoPostCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.*;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_posts.PromoPostsResponse;
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
    public ResponseEntity newPost(@RequestBody PostRequestDTO postRequestDTO) {
        postService.newPost(postRequestDTO);
        return new ResponseEntity("todo OK",HttpStatus.OK);
    }

    //Obtiene los posts hechos post hechos en las ultimas dos semanas por los usuarios que sigue el usuario {userId}.
    //Ordenados por default con fecha descendiente, se puede incluir "order=asc" en el queryString para ordenar por fecha ascendiente
    @GetMapping("/followed/{userId}/list")
    public FollowedUsersPostsResponse getFollowedUsersPosts(@PathVariable int userId,
                                                            @RequestParam(required = false) String order){
        return postService.getFollowedUsersPosts(userId, order);
    }

    //Creates post with a discount.
    @PostMapping("/promo-post")
    public ResponseEntity newPromoPost(@RequestBody PromoPostRequest request){
        postService.newPromoPost(request);
        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/promo-post/count")
    public PromoPostCountDTO countPromoPost(@RequestParam(name = "user_id") int userId){

        return postService.getPromoPostCount(userId);

    }

    @GetMapping("/promo-post/list")
    public PromoPostsResponse getPromoPosts(@RequestParam(name = "user_id") int userId){

        return postService.getPromoPosts(userId);

    }
}
