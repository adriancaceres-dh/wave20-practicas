package com.socialmeli.be_java_hisp_w20_g8.controllers;


import com.socialmeli.be_java_hisp_w20_g8.services.sellers.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    ISellerService sellerService;

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<Set<Integer>> getSellerFollowers(@PathVariable Integer userId){
        return new ResponseEntity<Set<Integer>>(sellerService.getFollowers(userId), HttpStatus.OK);

    }
}
