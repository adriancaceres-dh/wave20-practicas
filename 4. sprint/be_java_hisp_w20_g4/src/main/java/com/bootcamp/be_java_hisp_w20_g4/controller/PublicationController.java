package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductsPromotionSellerDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.service.publication.IServicePublication;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<PublicationDTO> addPromo (@RequestBody PostPromotionDTO promoProductDTO){
        return ResponseEntity.ok().body(servicePublication.addPublicationHasPromotion(promoProductDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<ProductCountDTO> promoProductsOfSeller(@RequestParam(value="user_id",required = true) int userId){
        return ResponseEntity.ok().body(servicePublication.countPublicationHasPromo(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<ProductsPromotionSellerDTO> promoProductsListOfSeller(@RequestParam(value="user_id",required = true) int userId){
        return ResponseEntity.ok().body(servicePublication.ProductHasPromotionOfSeller(userId));
    }


}
