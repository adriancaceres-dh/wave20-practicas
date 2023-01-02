package com.bootcamp.java.w20.be_java_hisp_w20_g05.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Override
    public int hashCode() {
        return id;
    }

    public void addFollower(int idFollower) {
        followers.add(Integer.valueOf(idFollower))
    }

    public void followUser(int idUserToFollow) {
        following.add(Integer.valueOf(idUserToFollow))
    }
}
