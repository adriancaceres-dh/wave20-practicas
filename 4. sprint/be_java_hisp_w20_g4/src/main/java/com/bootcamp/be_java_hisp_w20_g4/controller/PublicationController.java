package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PromoPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromoPublicationListDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromoPublicationCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PromoPublicationDTO;
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
    public ResponseEntity<PromoPublicationDTO> addPromo (@RequestBody PromoPostDTO promoPostDTO){
        return ResponseEntity.ok().body(servicePublication.addPromoPublication(promoPostDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPublicationCountDTO> promoProductsOfSeller(@RequestParam(value="user_id",required = false) Integer userId){
        return ResponseEntity.ok().body(servicePublication.getCountPromoPublications(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPublicationListDTO> promoProductsListOfSeller(@RequestParam(value="user_id",required = false) Integer userId){
        return ResponseEntity.ok().body(servicePublication.getPromoPublications(userId));
    }

    @GetMapping("/promo-post/promo-publications-in-range-price")
    public ResponseEntity<PromoPublicationListDTO> promoProductsInPriceRange(@RequestParam(value="from",required = false)  Double from ,
                                                                             @RequestParam(value="to",required = false)  Double to ,
                                                                             @RequestParam(value="user_id",required = false) Integer userId ,
                                                                             @RequestParam(value="order", required = false) String order){
        return ResponseEntity.ok().body(servicePublication.getPromoPublicationsInRangePrice(userId,from,to,order));
    }


}
