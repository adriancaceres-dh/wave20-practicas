package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserPostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserPromoProductsCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.service.publication.IServicePublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class PublicationController {
    @Autowired
    IServicePublication servicePublication;

    @PostMapping("/post")
    public ResponseEntity<PublicationDTO> add(@RequestBody PostDTO publicationDTO){
        return ResponseEntity.ok().body(servicePublication.addPublication(publicationDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ProductTwoWeeksResponseDTO> last2WeeksPublications(@PathVariable int userId, @RequestParam(value="order",required = false) String order){
        return ResponseEntity.ok().body(servicePublication.getLastTwoWeeksPublications(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PublicationDTO> addPromo (@RequestBody PostPromotionDTO publicationPromoDto){
        return ResponseEntity.ok().body(servicePublication.addPublicationPromotion(publicationPromoDto));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<UserPromoProductsCountDTO> CountPromoPublicationsOfSeller(@RequestParam(value="user_id", required = true) int userId){
        return ResponseEntity.ok().body(servicePublication.promoPublicationsCount(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<UserPostPromotionDTO> promoPublicationsOfSeller(@RequestParam(value="user_id", required = true) int userId){
        return ResponseEntity.ok().body(servicePublication.getPromoPublications(userId));
    }

    @GetMapping("/post-with/{productId}")
    public ResponseEntity<List<ListedPostDTO>> publicationsWithProduct(@PathVariable int productId){
        return ResponseEntity.ok().body(servicePublication.getProductPublications(productId));
    }


}
