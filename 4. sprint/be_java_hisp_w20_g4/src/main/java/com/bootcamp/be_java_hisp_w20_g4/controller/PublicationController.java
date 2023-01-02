package com.bootcamp.be_java_hisp_w20_g4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class PublicationController {

    @PostMapping("/post")
    public ResponseEntity<String> add(@RequestBody String publicationDTO){
        return ResponseEntity.ok().body("Response del service");
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<String> last2WeeksPublications(@PathVariable int userId){
        return ResponseEntity.ok().body("Response del service");
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
