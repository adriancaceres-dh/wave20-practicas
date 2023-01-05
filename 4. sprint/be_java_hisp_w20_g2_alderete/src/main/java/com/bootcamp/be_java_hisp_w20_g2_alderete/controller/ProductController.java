package com.bootcamp.be_java_hisp_w20_g2_alderete.controller;

import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.request.PromotionRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response.AmountOfPromotionsDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public PostResponseDTO<PostWithIdDTO> sendLastPostOfFollowed(@PathVariable int userId, @RequestParam Optional<String> order) {
        return productService.sendLastPostOfFollowed(userId, order);
    }

    // US-0010
    @PostMapping("/promo-post")
    @ResponseStatus(HttpStatus.OK)
    public String addNewPromoPost(@RequestBody PromotionRequestDTO postRequestDTO) {
        return productService.createPromoPost(postRequestDTO);
    }

    // US-0011
    @GetMapping("/promo-post/count")
    public AmountOfPromotionsDTO getAmountOfPromos(@RequestParam int user_id) {
        return productService.getAmountOfPromos(user_id);
    }

    // US-0012
    @GetMapping("/promo-post/{userId}/list")
    public PostResponseDTO<PostPromotionDTO> listPromosFromUser(@PathVariable int userId, @RequestParam Optional<String> order) {
        return productService.listPromosFromUser(userId, order);
    }

}
