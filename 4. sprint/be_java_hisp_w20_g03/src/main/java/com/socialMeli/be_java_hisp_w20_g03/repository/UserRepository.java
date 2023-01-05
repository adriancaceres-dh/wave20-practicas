package com.socialMeli.be_java_hisp_w20_g03.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.socialMeli.be_java_hisp_w20_g03.model.User;


@Repository
public class UserRepository implements IUserRepository {

    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
        User usuario1 = User.builder()
                .user_id(234)
                .user_name("usuario1")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario2 = User.builder()
                .user_id(6631)
                .user_name("usuario2")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario3 = User.builder()
                .user_id(4698)
                .user_name("usuario3")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario4 = User.builder()
                .user_id(1536)
                .user_name("usuario4")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario5 = User.builder()
                .user_id(2236)
                .user_name("usuario5")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario6 = User.builder()
                .user_id(6932)
                .user_name("usuario6")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario7 = User.builder()
                .user_id(123)
                .user_name("usuario7")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();

        usuario1.getFollowers().add(usuario2);
        usuario1.getFollowers().add(usuario3);
        usuario1.getFollowers().add(usuario4);
        usuario2.getFollowed().add(usuario1);
        usuario3.getFollowed().add(usuario1);
        usuario4.getFollowed().add(usuario1);

        usuario2.getFollowers().add(usuario3);
        usuario2.getFollowers().add(usuario4);
        usuario3.getFollowed().add(usuario2);
        usuario4.getFollowed().add(usuario2);

        userList.add(usuario1);
        userList.add(usuario2);
        userList.add(usuario3);
        userList.add(usuario4);
        userList.add(usuario5);
        userList.add(usuario6);
        userList.add(usuario7);

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
