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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
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


    public Optional<User> getById(int userId) {
        return users.stream().filter(u -> u.getId()== userId)
                .findFirst();
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
