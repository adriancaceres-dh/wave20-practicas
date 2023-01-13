package com.bootcamp.be_java_hisp_w20_g7.repository;

import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    List<User> users;

    public UserRepository() {

        users = loadData();
        //users = new ArrayList<>();
        //users.add(new User(1, "Sebastian"));
        //users.add(new User(2, "Manuel"));
        //users.add(new User(3, "Soraya"));
        //users.add(new User(4, "Ronald"));
        //users.add(new User(5, "Nathalia"));
        //users.add(new User(6, "Tomas"));
        //users.add(new User(7, "Stiven"));
        //users.add(new User(8, "Juan"));
    }

    @Override
    public User findById(int id) {
        return users.stream().filter(e -> e.getUserId() == id).findFirst().orElse(null);
    }

    public List<User> loadData(){
        List<User> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/main/resources/users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<List<User>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;
    }
}
