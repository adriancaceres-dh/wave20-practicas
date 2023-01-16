package com.bootcamp.be_java_hisp_w20_g2_espindola.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String userName;
    private List<User> followers;
    private List<User> following;
    private List<Post> posts;

    public User(String userName) {
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void follow(User user) {
        following.add(user);
    }

    public void addFollower(User user) {
        followers.add(user);
    }

    public void removeFollower(User user) {
        followers.remove(user);
    }

    public void removeFollowing(User user) {
        following.remove(user);
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}
