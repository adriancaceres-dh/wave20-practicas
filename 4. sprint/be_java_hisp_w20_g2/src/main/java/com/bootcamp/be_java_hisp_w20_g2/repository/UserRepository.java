package com.bootcamp.be_java_hisp_w20_g2.repository;

import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> userList;

    public UserRepository(){
        userList = new ArrayList<>();
        List<User> listaFollower1 = new ArrayList<>();
        List<User> listaFollowing1 = new ArrayList<>();
        List<User> listaFollower2 = new ArrayList<>();
        List<User> listaFollowing2 = new ArrayList<>();
        List<Post> postList1 = new ArrayList<>();
        List<Post> postList2 = new ArrayList<>();


        userList.add(new User(1, "Diego", listaFollower1, listaFollowing1, postList1));
        userList.add(new User(2, "Flavio", listaFollower2, listaFollowing2, postList2));
    }
    public User findUserById(int id){
        Optional<User> user = userList.stream().filter(user1 -> user1.getUserId() == id).findAny();
        return user.get();
    }

}
