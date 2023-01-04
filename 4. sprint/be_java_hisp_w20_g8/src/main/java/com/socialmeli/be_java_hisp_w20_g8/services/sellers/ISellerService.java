package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerFollowersDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserCountDTO;

public interface ISellerService<T> {
    public SellerFollowersDTO getSellerFollowers(Integer userId, String order);
    UserCountDTO followersCount(int userId);
}
