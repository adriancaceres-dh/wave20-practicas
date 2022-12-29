package com.socialmeli.be_java_hisp_w20_g8.models;

import java.util.Set;

public class User extends Person{

    private Set<Integer> following;

    public User(Integer id, String user_name, Set<Integer> following) {
        super(id, user_name);
        this.following = following;
    }

    public Set<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(Set<Integer> following) {
        this.following = following;
    }
}
