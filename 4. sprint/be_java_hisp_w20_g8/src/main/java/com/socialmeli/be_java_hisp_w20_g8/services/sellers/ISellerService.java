package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserDTO;

import java.util.Map;
import java.util.Set;

public interface ISellerService<T> {
    public Map<SellerDTO,Set<UserDTO>> getSellerFollowers(Integer userId);

}
