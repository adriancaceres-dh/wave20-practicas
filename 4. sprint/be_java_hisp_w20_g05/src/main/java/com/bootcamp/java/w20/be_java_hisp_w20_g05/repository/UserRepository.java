package com.bootcamp.java.w20.be_java_hisp_w20_g05.repository;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IRepository<User> {
    private Set<User> users= new HashSet<>();

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
    public Set<User> getAll(){return this.users;}

    @Override
    public Set<User> filterBy(String name) {
        return users.stream().filter(u -> u.getUserName().toLowerCase()
                        .matches("^.*" + name.toLowerCase() + ".*$"))
                .collect(Collectors.toSet());
    }

    public boolean addAll(List<User> users){ return this.users.addAll(users);}
    public User getById(int userId) {
        return users.stream().filter(u -> u.getId()== userId)
                .findFirst().orElseThrow(() -> new IdNotFoundException(new MessageExceptionDTO("No se encontro el usuario")));
    }
}
