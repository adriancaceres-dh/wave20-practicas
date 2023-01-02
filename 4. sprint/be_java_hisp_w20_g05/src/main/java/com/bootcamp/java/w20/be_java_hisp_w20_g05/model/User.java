package com.bootcamp.java.w20.be_java_hisp_w20_g05.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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

<<<<<<< Updated upstream
    public void addFollower(int idFollower) {
        followers.add(Integer.valueOf(idFollower));
    }

    public void followUser(int idUserToFollow) {
        following.add(Integer.valueOf(idUserToFollow));
    }

    public void removeFollower(int idFollower) {
        followers.remove(Integer.valueOf(idFollower));
    }

    public void unfollowUser(int idUserToUnfollow) {
        following.remove(Integer.valueOf(idUserToUnfollow));
    }
=======
>>>>>>> Stashed changes
}
