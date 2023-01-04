package com.bootcamp.be_java_hisp_w20_g7_anttury.repository;

import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.User;

public interface IUserRepository {

    User findById(int id);


}
