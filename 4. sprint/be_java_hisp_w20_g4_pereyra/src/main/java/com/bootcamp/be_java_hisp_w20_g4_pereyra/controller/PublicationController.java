package com.bootcamp.be_java_hisp_w20_g4_pereyra.controller;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.service.publication.IServicePublication;
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
    public ResponseEntity<String> addPromo (@RequestBody String promoProductDTO){
        return ResponseEntity.ok().body("Response del service");
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<String> promoProductsOfSeller(@RequestParam(value="user_id") String userId){
        return ResponseEntity.ok().body("Response del service");
    }


}
