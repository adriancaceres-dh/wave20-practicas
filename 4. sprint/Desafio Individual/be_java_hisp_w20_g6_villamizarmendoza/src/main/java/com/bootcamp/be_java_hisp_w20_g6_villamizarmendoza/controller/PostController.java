package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.controller;

import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.PostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.PromoPostCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.PromoPostListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.service.Interface.IPostService;

@RestController
@RequestMapping("products")
public class PostController {
    
    @Autowired
    private IPostService postService;

    @PostMapping(value = {"/post","promo-post"})
    public ResponseEntity<Boolean> save(@RequestBody PostRequestDto requestDto) {
        return new ResponseEntity<Boolean>(postService.save(requestDto), HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResponseDTO> getPost(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(postService.postFollowedLastWeeks(userId, order), HttpStatus.OK); 
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountResponseDto> getPromoPostCountByFollowed(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.getPromosCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListResponseDTO> getPromoPostBySeller(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.getPromoPostList(user_id, ""), HttpStatus.OK);
    }

}
