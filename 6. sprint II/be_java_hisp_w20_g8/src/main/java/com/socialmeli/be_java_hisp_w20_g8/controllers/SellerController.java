package com.socialmeli.be_java_hisp_w20_g8.controllers;


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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
public class SellerController {

    @Autowired
    ISellerService sellerService;


    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserCountDTO> countFollowers(@Positive(message = "El id debe ser mayor a cero") @PathVariable int userId){
        return ResponseEntity.ok().body(sellerService.followersCount(userId));
    }


    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<SellerFollowersDTO> getSellerFollowers(@Positive(message = "El id debe ser mayor a cero")
         @NotNull(message = "El ID no puede estar vacio") @PathVariable Integer userId, @RequestParam(required = false) String order){
            return new ResponseEntity<>(sellerService.getSellerFollowers(userId, order), HttpStatus.OK);
    }
}
