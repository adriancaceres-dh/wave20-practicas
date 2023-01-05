package com.bootcamp.be_java_hisp_w20_g4_stocco.controller;

import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.request.PostPromoDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.publication.PromoCountDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.publication.PublicationPromoDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.publication.PublicationSellerPromoDTO;
import com.bootcamp.be_java_hisp_w20_g4_stocco.service.publication.IServicePublication;
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
    public ResponseEntity<PublicationPromoDTO> addPublicationPromo (@RequestBody PostPromoDTO postPromoDTO){
        return ResponseEntity.ok().body(servicePublication.addPublicationPromo(postPromoDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoCountDTO> promoProductsOfSeller(@RequestParam(value="user_id") int userId){
        return ResponseEntity.ok().body(servicePublication.countPublicationPromo(userId));
    }
    @GetMapping("/promo-post/list")
    public  ResponseEntity<PublicationSellerPromoDTO> promoPostList(@RequestParam(value="user_id") int user_id){
        return  ResponseEntity.ok().body(servicePublication.publicationSellerPromo(user_id));
    }

}
