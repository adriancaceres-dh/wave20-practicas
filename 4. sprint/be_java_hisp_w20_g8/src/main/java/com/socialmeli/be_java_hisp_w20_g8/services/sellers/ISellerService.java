package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.UserCountDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.User;

import java.util.List;

public interface ISellerService {


    UserCountDTO followersCount(int userId);

}
