package com.socialMeli.be_java_hisp_w20_g03.repository;

import java.util.ArrayList;

import java.util.List;

import com.socialMeli.be_java_hisp_w20_g03.model.Post;
import org.springframework.stereotype.Repository;
import com.socialMeli.be_java_hisp_w20_g03.model.User;


@Repository
public class UserRepository implements IUserRepository {

    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
        User usuario1 = User.builder()
                .userId(234)
                .userName("usuario1")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario2 = User.builder()
                .userId(6631)
                .userName("usuario2")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario3 = User.builder()
                .userId(4698)
                .userName("usuario3")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario4 = User.builder()
                .userId(1536)
                .userName("usuario4")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario5 = User.builder()
                .userId(2236)
                .userName("usuario5")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario6 = User.builder()
                .userId(6932)
                .userName("usuario6")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario7 = User.builder()
                .userId(123)
                .userName("usuario7")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();

        usuario1.getFollowers().add(usuario2);
        usuario2.getFollowed().add(usuario1);

        usuario1.getFollowers().add(usuario3);
        usuario3.getFollowed().add(usuario1);

        usuario3.getFollowers().add(usuario1);
        usuario1.getFollowed().add(usuario3);

        usuario1.getFollowers().add(usuario4);
        usuario4.getFollowed().add(usuario1);

        usuario2.getFollowers().add(usuario3);
        usuario3.getFollowed().add(usuario2);

        usuario2.getFollowers().add(usuario4);
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
                .filter(user -> user.getUserId() == userId)
                .findAny()
                .orElse(null);
    }

    public boolean addUser(User user) {
        userList.add(user);
        return true;
    }

}
