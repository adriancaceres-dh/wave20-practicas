package com.project.projectdatabase.services;

import com.project.projectdatabase.entity.Users;
import com.project.projectdatabase.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUsersService{
    @Autowired
    private IUsersRepository iUsersRepository;

    private Users users;

    @Override
    public Users createNewUser(Users users) {
        users = iUsersRepository.save(users);
        return users;
    }

    @Override
    public List<Users> findAllUsers() {
        List<Users> listUsers = iUsersRepository.findAll();
        return listUsers;
    }

    @Override
    public Users findUsersById(Integer id) {
        users = iUsersRepository.findById(id).get();
        return users;
    }

    @Override
    public void deleteUserById(Integer id) {
        iUsersRepository.deleteById(id);
    }
}
