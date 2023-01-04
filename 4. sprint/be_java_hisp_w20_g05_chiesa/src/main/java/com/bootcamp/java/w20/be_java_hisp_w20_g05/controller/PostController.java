package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostPromoRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.InvalidPostDataException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
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
    public ResponseEntity newPost(@RequestBody PostRequestDTO postRequestDTO) {
        postService.newPost(postRequestDTO);
        return new ResponseEntity("todo OK",HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity newPostPromo(@RequestBody PostPromoRequestDTO postRequestDTO) {
        if(postRequestDTO.getDiscount() == 0 || !postRequestDTO.isHasPromo()) throw new InvalidPostDataException(new MessageExceptionDTO("Not a promo"));
        postService.newPostPromo(postRequestDTO);
        return new ResponseEntity("todo OK",HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoCountDTO> getPromoCountByUserId(@RequestParam int user_id) {
        return new ResponseEntity(postService.getPromoCountByUserId(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoListDTO> getPromoProductsByUserId(@RequestParam int user_id){
        return new ResponseEntity(postService.getPromoProductsByUserId(user_id), HttpStatus.OK);
        //return new ResponseEntity(user_id, HttpStatus.OK);
    }

    //Obtiene los posts hechos post hechos en las ultimas dos semanas por los usuarios que sigue el usuario {userId}.
    //Ordenados por default con fecha descendiente, se puede incluir "order=asc" en el queryString para ordenar por fecha ascendiente
    @GetMapping("/followed/{userId}/list")
    public FollowedUsersPostsResponse getFollowedUsersPosts(@PathVariable int userId,
                                                            @RequestParam(required = false) String order){
        return postService.getFollowedUsersPosts(userId, order);
    }
}
