package com.bootcamp.be_java_hisp_w20_g7.repository;

import com.bootcamp.be_java_hisp_w20_g7.entity.User;

import java.util.Optional;

public interface IUserRepository {

    User findById(int id);


}
