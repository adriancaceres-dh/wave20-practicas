package com.bootcamp.java.w20.be_java_hisp_w20_g05.repository;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.exception.NotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IRepository<User> {
    private Set<User> users;

    @Override
    public boolean contains(User user) {
        return users.contains(user);
    }
    @Override
    public boolean add(User user) {
        if (contains(user)) return false;
        return users.add(user);
    }

    @Override
    public Set<User> filterBy(String name) {
        return users.stream().filter(u -> u.getUserName().toLowerCase()
                        .matches("^.*" + name.toLowerCase() + ".*$"))
                .collect(Collectors.toSet());
    }
    public User getById(int userId) {
        return users.stream().filter(u -> u.getId()== userId)
                .findFirst().orElseThrow(() -> new NotFoundException("No se encontro el usuario"));
    }

}
