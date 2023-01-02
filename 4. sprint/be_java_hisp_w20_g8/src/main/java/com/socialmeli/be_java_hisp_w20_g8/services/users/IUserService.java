package com.socialmeli.be_java_hisp_w20_g8.services.users;

import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;

public interface IUserService {
    public ResponseDto addNewFollow(int userId, int sellerId);

    public ResponseDto unfollow(int userid, int sellerId);
}
