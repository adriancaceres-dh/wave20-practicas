package com.socialmeli.be_java_hisp_w20_g8.controllers;


import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.services.users.IUserService;
import com.socialmeli.be_java_hisp_w20_g8.services.users.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{userId}/followed/list")
    public List<SellerDTO> getFollowed(@PathVariable int userId){
        return userService.getAllFollowed(userId).stream().map(seller -> {
            SellerDTO sellerDTO = new SellerDTO(seller.getId(),seller.getUser_name());
            return SellerDTO.builder().
                    user_id(seller.getId()).
                    user_name(seller.getUser_name()).
                    build();
        }).collect(Collectors.toList());
    }
}
