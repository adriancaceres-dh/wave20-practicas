package com.bootcamp.be_java_hisp_w20_g7.repository;

import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.bootcamp.be_java_hisp_w20_g7.exception.UserNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository{

    List<User> users;

    public UserRepository(){
        users = new ArrayList<>();
        users.add(new User(1,"Sebastian"));
        users.add(new User(2,"Manuel"));
        users.add(new User(3,"Soraya"));
        users.add(new User(4,"Ronald"));
        users.add(new User(5,"Nathalia"));
        users.add(new User(6,"Tomas"));
        users.add(new User(7,"Stive"));
        users.add(new User(8,"Juan"));
    }

    @Override
    public User findById(int id) {
        User user = users.stream().filter(e -> e.getUserId() == id).findFirst().orElse(null);

        if(user == null){
            throw new UserNotFoundException("user with id " + id + " not found");
        }

        return user;
    }
}
