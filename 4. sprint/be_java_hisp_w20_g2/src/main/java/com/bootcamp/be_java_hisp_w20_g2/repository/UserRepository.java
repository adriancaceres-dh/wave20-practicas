package com.bootcamp.be_java_hisp_w20_g2.repository;

import com.bootcamp.be_java_hisp_w20_g2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {
    private static int currentId = 0;
    //estas?
    private final HashMap<Integer, User> users;
    @Autowired
    private PostRepository postRepository;

    public UserRepository() {
        users = new HashMap<>();

        User diego = new User("Diego");
        User flavio = new User("Flavio");
        User ale = new User("Ale");
        diego.follow(flavio);
        ale.follow(flavio);
        flavio.addFollower(diego);
        flavio.addFollower(ale);

        save(diego);
        save(flavio);
        save(ale);
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(currentId++);
        }
        users.put(user.getId(), user);
        user.getPosts().forEach(p -> postRepository.save(p));
        return user;
    }

    public User findOne(int id) {
        return users.get(id);
    }

    public boolean exists(int id) {
        return users.containsKey(id);
    }

}
