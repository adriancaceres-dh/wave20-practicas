package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ListProductsInPromoDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.PromoProductsCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.service.publication.IServicePublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<PromoPostDTO> addPromo (@RequestBody PromoPostDTO promoPostDTO){
        return ResponseEntity.ok().body(servicePublication.addPromo(promoPostDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDTO> promoProductsOfSeller(@RequestParam(value="user_id") int userId){
        return ResponseEntity.ok().body(servicePublication.countPromos(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<ListProductsInPromoDTO> listProductsInPromo(@RequestParam(value = "user_id", required = true) int userId){
        return ResponseEntity.ok().body(servicePublication.listPromos(userId));
    }

}
