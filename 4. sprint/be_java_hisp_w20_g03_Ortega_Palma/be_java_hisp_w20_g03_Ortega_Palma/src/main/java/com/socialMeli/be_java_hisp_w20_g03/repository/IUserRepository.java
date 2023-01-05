package com.socialMeli.be_java_hisp_w20_g03.repository;

import com.socialMeli.be_java_hisp_w20_g03.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> getUsers();
    User getUserById(int userId);
}
