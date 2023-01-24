package com.project.projectdatabase.services;

import com.project.projectdatabase.entity.Users;

import java.util.List;

public interface IUsersService {

    Users createNewUser(Users users);
    List<Users> findAllUsers();
    Users findUsersById(Integer id);

    void deleteUserById(Integer id);

}
