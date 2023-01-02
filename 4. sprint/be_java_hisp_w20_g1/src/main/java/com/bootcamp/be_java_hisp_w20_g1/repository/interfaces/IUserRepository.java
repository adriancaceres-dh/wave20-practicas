package com.bootcamp.be_java_hisp_w20_g1.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.model.User;

public interface IUserRepository {
     User getUserById(int id);
     boolean isValidId(int id);
     boolean isSeller(int id);

     void addFollowed(int userIdToModify, int userIdToFollow);
     void addFollower(int userIdToModify, int userIdToFollow);
     void removeFollowed(int userIdToModify, int userIdToFollow) ;
     void removeFollower(int userIdToModify, int userIdToFollow);

}
