package com.bootcamp.be_java_hisp_w20_g2.repository;

import com.bootcamp.be_java_hisp_w20_g2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {
//estas?
    private final HashMap<Integer, User> users;
    private static int currentId = 0;

    @Autowired
    private PostRepository postRepository;

    public UserRepository(){
        users = new HashMap<>();

        User diego = new User("Diego");
        User flavio = new User("Flavio");
        diego.follow(flavio);
        flavio.addFollower(diego);

        save(diego);
        save(flavio);
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(currentId++);
        }
        users.put(user.getId(), user);
        user.getPosts().forEach(p -> postRepository.save(p));
        return user;
    }

    public User findOne(int id){
        return users.get(id);
    }

    public boolean exists(int id) {
        return users.containsKey(id);
    }

}
