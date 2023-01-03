package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDiscountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.PublicationDiscountDTO;
import com.bootcamp.be_java_hisp_w20_g4.repository.IPublicationRepository;
import com.bootcamp.be_java_hisp_w20_g4.service.IServicePublication;
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
    public ResponseEntity<String> last2WeeksPublications(@PathVariable int userId){
        return ResponseEntity.ok().body("Response del service");
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PublicationDiscountDTO> addPromo (@RequestBody(required = false) PostDiscountDTO postDiscountDTO, @RequestBody(required = false) PostDTO postDTO){
        return ResponseEntity.ok().body(servicePublication.addPromoPublication(postDiscountDTO, postDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<String> promoProductsOfSeller(@RequestParam(value="user_id") String userId){
        return ResponseEntity.ok().body("Response del service");
    }


}
