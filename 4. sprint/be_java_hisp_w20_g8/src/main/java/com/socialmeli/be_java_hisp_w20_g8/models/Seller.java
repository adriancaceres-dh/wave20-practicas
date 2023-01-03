package com.socialmeli.be_java_hisp_w20_g8.models;

import java.util.Set;

public class Seller extends Person {

    private Set<Integer> followers;
    private Set<Integer> post;

    public Seller(Integer id, String user_name, Set<Integer> followers, Set<Integer> post) {
        super(id, user_name);
        this.followers = followers;
        this.post = post;
    }

    public Set<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Integer> followers) {
        this.followers = followers;
    }

    public Set<Integer> getPost() {
        return post;
    }

    public void setPost(Set<Integer> post) {
        this.post = post;
    }


}
