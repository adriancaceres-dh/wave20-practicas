package com.bootcamp.java.w20.be_java_hisp_w20_g05.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private int id;
    private String userName;
    private Set<Integer> followers;
    private Set<Integer> following;

    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
        followers = new HashSet<>();
        following = new HashSet<>();
    }

    @Override
    public int hashCode() {
        return id;
    }

    public boolean addFollower(int idFollower) { return followers.add(idFollower); }

    public boolean followUser(int idUserToFollow) { return following.add(idUserToFollow); }

    public boolean removeFollower(int idFollower) {
        return followers.remove(idFollower);
    }

    public boolean unfollowUser(int idUserToUnfollow) {
        return following.remove(idUserToUnfollow);
    }
}
