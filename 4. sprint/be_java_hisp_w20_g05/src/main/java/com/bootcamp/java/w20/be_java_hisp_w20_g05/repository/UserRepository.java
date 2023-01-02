package com.bootcamp.java.w20.be_java_hisp_w20_g05.repository;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IRepository<User> {
    private Set<User> users= new HashSet<>();

    public UserRepository(){
        users = loadDataBase();
    }

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

    private static Set<User> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Set<User>> typeRef = new TypeReference<>() {};
        Set<User> users = null;

        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
