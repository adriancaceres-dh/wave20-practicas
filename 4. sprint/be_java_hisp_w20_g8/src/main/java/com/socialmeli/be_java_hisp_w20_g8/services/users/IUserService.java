package com.socialmeli.be_java_hisp_w20_g8.services.users;

import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;

import java.util.List;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;

public interface IUserService {

    public ResponseDto addNewFollow(int userId, int sellerId);
    public List<Seller> getAllFollowed(int userId);

}
