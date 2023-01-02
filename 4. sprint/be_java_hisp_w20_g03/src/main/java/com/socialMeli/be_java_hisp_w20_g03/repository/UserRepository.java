package com.socialMeli.be_java_hisp_w20_g03.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.socialMeli.be_java_hisp_w20_g03.model.User;


@Repository
public class UserRepository implements IUserRepository {

    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();

        userList.add(new User(234, "vendedor1", new ArrayList<User>(), new ArrayList<>()));
        userList.add(new User(4698, "usuario1", new ArrayList<User>(), List.of(
                new User(123,"vendedor4", new ArrayList<User>(), new ArrayList<User>()),
                new User(781,"usuario4", new ArrayList<User>(), new ArrayList<User>()),
                new User(6631,"vendedor3", new ArrayList<User>(), new ArrayList<User>()))));
        userList.add(new User(1536, "usuario2", new ArrayList<User>(), new ArrayList<User>()));
        userList.add(new User(2236, "usuario3", new ArrayList<User>(), new ArrayList<User>()));
        userList.add(new User(6932, "vendedor2", new ArrayList<User>(), new ArrayList<User>()));
        userList.add(new User(6631, "vendedor3", new ArrayList<User>(), new ArrayList<User>()));
        userList.add(new User(123, "vendedor4", new ArrayList<User>(), new ArrayList<User>()));
    }

    public List<User> getUsers() {
        return this.userList;
    }

    public User getUserById(int userId) {
        return this.userList.stream()
                .filter(user -> user.getUser_id() == userId)
                .findAny()
                .orElse(null);
    }
}
