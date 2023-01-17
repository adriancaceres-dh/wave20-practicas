package com.bootcamp.be_java_hisp_w20_g7.controller;

import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    IPostService postService;

    //US 0005: Dar de alta una nueva publicación
    @PostMapping("/post")
    ResponseEntity<String> postAdd(@RequestBody @Valid PostCreateDto post) {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas
    // (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    //US 0009: Ordenamiento por fecha ascendente y descendente
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostFollowedDto> postUsersFollowed(
            @PathVariable int userId,
            @RequestParam(required = false) String order) {

        return new ResponseEntity<>(postService.postUsersFollowed(userId, order), HttpStatus.OK);
    }
}
