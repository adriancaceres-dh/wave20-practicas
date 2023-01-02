package com.bootcamp.be_java_hisp_w20_g4.repository;


import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{

    private List<User> users = loadUsers();

    public UserRepository(){}

    private List<User> loadUsers() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:publication.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> users = null;
        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User findById(int idUser){
        return users.stream().filter(x->x.getId() == idUser).findFirst().orElse(null);
    }

}
