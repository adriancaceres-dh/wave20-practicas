package com.socialmeli.be_java_hisp_w20_g8.controllers;


import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.services.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/{userIdS}/followed/list")
    public List<SellerDTO> getFollowed(@PathVariable String userIdS) throws OperationFailedException{
        try{
            Integer userId = Integer.parseInt(userIdS);
            return userService.getAllFollowed(userId).stream().map(seller -> {
                SellerDTO sellerDTO = new SellerDTO(seller.getId(), seller.getUser_name());
                return SellerDTO.builder().
                        seller_id(seller.getId()).
                        user_name(seller.getUser_name()).
                        build();
            }).collect(Collectors.toList());

        }catch (NumberFormatException e){
            throw  new OperationFailedException( "Invalid User Id");
        }
    }

    @GetMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDto> newFollow(@PathVariable int userId, @PathVariable int sellerId){
        try{
            return new ResponseEntity<>(userService.addNewFollow(userId, sellerId), HttpStatus.OK);
        }
        catch (NumberFormatException e){
            throw  new OperationFailedException(e.getMessage() + " Please check the information");
        }
    }
}
