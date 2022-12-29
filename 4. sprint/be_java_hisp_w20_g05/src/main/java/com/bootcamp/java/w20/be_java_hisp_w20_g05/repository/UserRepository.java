package com.bootcamp.java.w20.be_java_hisp_w20_g05.repository;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IRepository<User> {
    private List<User> users;

    @Override
    public boolean contains(User user) {
        return users.contains(user);
    }
    @Override
    public boolean add(User user) {
        if (users.contains(user)) return false;
        return users.add(user);
    }

    @Override
    public List<User> filterBy(String name) {
        return users.stream().filter(u -> u.getUserName().toLowerCase()
                        .matches("^.*" + name.toLowerCase() + ".*$"))
                .collect(Collectors.toList());
    }
}
