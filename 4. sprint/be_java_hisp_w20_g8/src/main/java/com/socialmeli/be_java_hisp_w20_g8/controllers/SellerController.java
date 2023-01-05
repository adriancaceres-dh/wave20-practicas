package com.socialmeli.be_java_hisp_w20_g8.controllers;


import com.socialmeli.be_java_hisp_w20_g8.dto.PromosBySellerDto;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponsePostDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.SellerFollowersDTO;
import com.socialmeli.be_java_hisp_w20_g8.services.sellers.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserCountDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {

    @Autowired
    private ISellerService sellerService;


    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserCountDTO> countFollowers(@PathVariable int userId){
        return ResponseEntity.ok().body(sellerService.followersCount(userId));
    }


    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<SellerFollowersDTO> getSellerFollowers(@PathVariable Integer userId, @RequestParam(required = false) String order){
            return new ResponseEntity<>(sellerService.getSellerFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromosBySellerDto> getPromosBySellerCount(@RequestParam int userId){
        return new ResponseEntity<>(sellerService.countPromos(userId),HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<ResponsePostDTO> getPromoPostBySeller(@RequestParam int userId){
        return new ResponseEntity<>(sellerService.getAllPromoPostBySeller(userId),HttpStatus.OK);
    }
}
