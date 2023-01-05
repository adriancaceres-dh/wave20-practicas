package com.socialmeli.be_java_hisp_w20_g8.services.users;

import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;

import java.util.List;

public interface IUserService {

    ResponseDto addNewFollow(int userId, int sellerId);
    UserFollowedDTO getAllFollowed(int userId, String order);
    ResponseDto unfollow(int userid, int sellerId);
    ResponseDto newUser(UserDTO newUser);
    List<UserDTO> allUsers();
}
