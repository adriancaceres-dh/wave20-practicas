package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
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

    @PostMapping(path = "/post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewPost(@RequestBody PostDTO newPost) {
        // Validar que las fechas esten correctas al ingresar. ¿Qué pasa si se le poné algo mal desde el comienzo?
        postService.createPost(newPost);
    }

    @GetMapping("/followed/{userId}/list")
    public PostResponseDTO sendLastPostOfFollowed(@PathVariable int userId, @RequestParam Optional<String> order) {
        return postService.sendLastPostOfFollowed(userId, order);
    }

    @PostMapping("/promo-post")
    @ResponseStatus(HttpStatus.OK)
    public void addNewPromoPost(@RequestBody PromoPostRequestDTO postRequestDTO) {
        postService.createPromoPost(postRequestDTO);
    }

}
