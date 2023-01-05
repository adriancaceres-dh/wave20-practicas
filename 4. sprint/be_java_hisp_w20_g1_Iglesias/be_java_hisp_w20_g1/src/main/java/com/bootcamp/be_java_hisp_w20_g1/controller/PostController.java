package com.bootcamp.be_java_hisp_w20_g1.controller;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostPromoRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.CountProductWithDiscountDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.ListOfProductsWithDiscountDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.postResponsePromoDto;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IPostService;

import javax.annotation.PostConstruct;

import org.modelmapper.internal.bytebuddy.asm.Advice.PostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResponseDto> lastTwoWeeksPostsFromFollowers (@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(postService.lastTwoWeeksPostsFromFollowers(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDto> addPost(@RequestBody PostRequestDto post) {
        return ResponseEntity.ok(postService.add(post));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<postResponsePromoDto> addPostWithDiscount(@RequestBody PostPromoRequestDto dto){
        return new ResponseEntity<>(postService.addWithPromo(dto), HttpStatus.CREATED);
    }
    
    @GetMapping("/promo-post/count")
    public CountProductWithDiscountDto numberOfProductWithDiscount(@RequestParam int userId) {
    	return postService.CountProductWithDiscount(userId);
    }
    @GetMapping("/promo-post/list")
    public ListOfProductsWithDiscountDto ListProductsWithDiscountOfASeller(@RequestParam int user_id) {
    return postService.productsWithDiscount(user_id);
    }
    
}
