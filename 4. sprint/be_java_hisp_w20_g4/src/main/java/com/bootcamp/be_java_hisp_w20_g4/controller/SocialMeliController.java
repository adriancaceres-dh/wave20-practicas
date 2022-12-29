package com.bootcamp.be_java_hisp_w20_g4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMeliController {

    //agregar autowired del service

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> follow(@PathVariable int userId , @PathVariable int userIdToFollow){
        return ResponseEntity.ok().body("Respuesta del service");
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<String> followersCount(@PathVariable int userId){
        return ResponseEntity.ok().body("Response del service");
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<String> followers(@PathVariable int userId , @RequestParam(value="order",required = false) String order){
        return ResponseEntity.ok().body("Response del service");
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<String> followed(@PathVariable int userId , @RequestParam(value="order",required = false) String order){
        return ResponseEntity.ok().body("Response del service");
    }

    @PostMapping("/products/post")
    public ResponseEntity<String> add(@RequestBody String publicationDTO){
        return ResponseEntity.ok().body("Response del service");
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<String> last2WeeksPublications(@PathVariable int userId){
        return ResponseEntity.ok().body("Response del service");
    }

    @GetMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable int userId , @PathVariable int userIdToUnfollow){
        return ResponseEntity.ok().body("Response del service");
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<String> addPromo (@RequestBody String promoProductDTO){
        return ResponseEntity.ok().body("Response del service");
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<String> promoProductsOfSeller(@RequestParam(value="user_id") String userId){
        return ResponseEntity.ok().body("Response del service");
    }

}
