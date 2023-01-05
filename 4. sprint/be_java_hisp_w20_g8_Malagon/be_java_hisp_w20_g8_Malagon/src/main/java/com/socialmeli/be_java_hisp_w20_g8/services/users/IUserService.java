package com.socialmeli.be_java_hisp_w20_g8.services.users;

import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserAndFollowedsDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;

public interface IUserService {

    public ResponseDto addNewFollow(int userId, int sellerId);
    public UserFollowedDTO getAllFollowed(int userId, String order);
    public ResponseDto unfollow(int userid, int sellerId);

    public UserAndFollowedsDTO getCountFollowed(int userId);
}
