package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.models.User;

import java.util.List;

public interface ISellerService {

    List<User> countUser(int userId);

}
