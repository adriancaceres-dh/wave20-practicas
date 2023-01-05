package com.socialmeli.be_java_hisp_w20_g8.services.users;

import com.socialmeli.be_java_hisp_w20_g8.dto.response.ResponseMessageDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;

public interface IUserService {

    public ResponseMessageDTO addNewFollow(int userId, int sellerId);
    public UserFollowedDTO getAllFollowed(int userId, String order);
    public ResponseMessageDTO unfollow(int userid, int sellerId);
}
