package com.bootcamp.be_java_hisp_w20_g4_stocco.repository.user;

import com.bootcamp.be_java_hisp_w20_g4_stocco.model.User;

public interface IUserRepository {

    public User findById(int idUser);
}
