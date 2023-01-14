package com.bootcamp.be_java_hisp_w20_g2.util;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UtilsTest {
    public static HashMap<Integer,User> generateUsersToTestFollow(){
        User user1 = new User(1,"usuario1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"usuario2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user1.addFollower(user2);


        HashMap<Integer,User> users = new HashMap<>();
        users.put(1,user1);
        users.put(2,user2);
        return users;

    }

    public static HashMap<Integer,User> generateUsersForTestTwo(){
        User user1 = new User(1,"usuario1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"usuario2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user2.addFollower(user1);
        user1.getFollowing().add(user2);
        HashMap<Integer,User> users = new HashMap<>();
        users.put(1,user1);
        users.put(2,user2);
        return users;

    }

    public static HashMap<Integer,User> generateUsersToTestExistingFollow(){
        User user1 = new User(1,"usuario1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"usuario2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user2.addFollower(user1);
        user1.getFollowing().add(user2);
        HashMap<Integer,User> users = new HashMap<>();
        users.put(1,user1);
        users.put(2,user2);
        return users;

    }

    public static User generateUserToTestFollowerList(){
        User user = new User("Mariano");
        user.setId(2);
        user.addFollower(new User("Luis"));
        user.addFollower(new User("Francisco"));
        user.addFollower(new User("Lorenzo"));
        return user;
    }
}
