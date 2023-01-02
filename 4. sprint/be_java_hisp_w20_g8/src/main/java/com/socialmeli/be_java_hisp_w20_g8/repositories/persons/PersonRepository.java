package com.socialmeli.be_java_hisp_w20_g8.repositories.persons;

public interface PersonRepository {

    public boolean addFollowing(int userId, int sellerId);

    public boolean addFollower(int sellerId, int userId);

    public boolean checkUser(int userId);

    public boolean unfollowing(int userId, int sellerId);

    public boolean unfollower(int sellerId, int userId);

}
