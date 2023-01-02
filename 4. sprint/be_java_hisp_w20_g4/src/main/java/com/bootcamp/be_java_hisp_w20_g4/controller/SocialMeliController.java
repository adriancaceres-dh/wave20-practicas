package com.bootcamp.be_java_hisp_w20_g4.controller;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w20_g4.service.IServicePublication;
import com.bootcamp.be_java_hisp_w20_g4.service.IServiceUsr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMeliController {

    @Autowired
    IServicePublication publicationService;

    @Autowired
    IServiceUsr usrService;



    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserDTO> follow(@PathVariable int userId , @PathVariable int userIdToFollow){
        return ResponseEntity.ok().body(usrService.follow(userId, userIdToFollow));
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserCountDTO> followersCount(@PathVariable int userId){
        return ResponseEntity.ok().body(usrService.followersCount(userId));
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

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
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
