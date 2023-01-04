package com.bootcamp.be_java_hisp_w20_g2.controller;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PromosAmountDTO;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    // US-0005
    @PostMapping(path = "/post")
    @ResponseStatus(HttpStatus.OK)
    public String addNewProduct(@RequestBody PostDTO newPost) {
        return productService.createPost(newPost);
    }

    // US-0006 - US-0009
    @GetMapping("followed/{userId}/list")
    public PostResponseDTO sendLastPostOfFollowed(@PathVariable int userId, @RequestParam Optional<String> order) {
        return productService.sendLastPostOfFollowed(userId, order);
    }

    // US-0010
    @PostMapping("/promo-post")
    @ResponseStatus(HttpStatus.OK)
    public String addNewPromoPost(@RequestBody PromoPostRequestDTO postRequestDTO) {
        return productService.createPromoPost(postRequestDTO);
    }

    // US-0011
    @GetMapping("/promo-post/count")
    public PromosAmountDTO getAmountOfPromos(@RequestParam int user_id) {
        return productService.getAmountOfPromos(user_id);
    }

    // US-0012
    @GetMapping("/promo-post/{userId}/list")
    public PostResponseDTO listPromosFromUser(@PathVariable int userId, @RequestParam Optional<String> order) {
        return productService.listPromosFromUser(userId, order);
    }

    // US-0013
    @GetMapping("/promo-post/list")
    public List<PostWithIdDTO> listPromos(@RequestParam Optional<String> order) {
        return productService.listPromos(order);
    }
}
