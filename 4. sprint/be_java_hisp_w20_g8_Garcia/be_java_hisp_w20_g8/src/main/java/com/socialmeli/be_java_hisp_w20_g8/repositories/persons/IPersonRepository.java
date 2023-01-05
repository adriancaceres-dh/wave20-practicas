package com.socialmeli.be_java_hisp_w20_g8.repositories.persons;

import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;

import java.util.Set;

public interface IPersonRepository {

    public boolean addFollowing(int userId,int sellerId);
    public boolean addFollower(int sellerId, int userId);
    public boolean checkUser(int userId);

    public boolean unfollowing(int userId, int sellerId);

    public boolean unfollower(int sellerId, int userId);

    Set<Integer> getAllFollowed(int userId);
    Seller findSellerById(Integer seller_id);

    Seller getById(int id);
     public User findUserById(Integer id);
     public Set<Integer> GetSellerFollowers(int userId);


}
