package com.bootcamp.be_java_hisp_w20_g2.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.model.User;

public interface IUserService {

    User findUser(int userIdFind);

    void saveUser(User user);
}
