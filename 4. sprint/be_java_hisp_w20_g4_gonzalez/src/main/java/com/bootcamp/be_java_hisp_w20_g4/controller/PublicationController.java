package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PromotionPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.FilteredPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromotionPublicationCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromotionPublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
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
    public ResponseEntity<PromotionPublicationDTO> addPromo (@RequestBody PromotionPostDTO promoProductDTO){
        return ResponseEntity.ok().body(servicePublication.addPublicationWithPromo(promoProductDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromotionPublicationCountDTO> promoProductsOfSeller(@RequestParam(value="user_id") int userId){
        return ResponseEntity.ok().body(servicePublication.getPromoPublications(userId));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<FilteredPostDTO>> getPublicationsByPrice(@RequestParam(value="min", required = false) Double min, @RequestParam(value = "max", required = false) Double max){
        return ResponseEntity.ok().body(servicePublication.getPublicationsByPrice(min, max));
    }
}
