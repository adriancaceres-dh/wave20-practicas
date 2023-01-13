package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.*;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@Validated
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<PostResponseDTO> newPost(@RequestBody @Valid PostRequestDTO postRequestDTO) {
        return new ResponseEntity<>(postService.newPost(postRequestDTO),HttpStatus.OK);
    }

    //Obtiene los posts hechos post hechos en las ultimas dos semanas por los usuarios que sigue el usuario {userId}.
    //Ordenados por default con fecha descendiente, se puede incluir "order=asc" en el queryString para ordenar por fecha ascendiente
    @GetMapping("/followed/{userId}/list")
    public FollowedUsersPostsResponse getFollowedUsersPosts(@PathVariable @Min(value = 1, message= "El Id debe ser mayor a 0.") int userId,
                                                            @RequestParam(required = false) String order){
        return postService.getFollowedUsersPosts(userId, order);
    }
}
