package com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.user;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.User;

public interface IUserRepository {

    public User findById(int idUser);
}
