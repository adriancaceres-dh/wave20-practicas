package com.bootcamp.be_java_hisp_w20_ramosruiz.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_ramosruiz.model.User;

public interface IUserRepository {
     User getUserById(int id);
     boolean isValidId(int id);
     boolean isSeller(int id);
     User addFollowed(int userIdToModify, int userIdToFollow);
     User addFollower(int userIdToModify, int userIdToFollow);
     User removeFollowed(int userIdToModify, int userIdToFollow) ;
     User removeFollower(int userIdToModify, int userIdToFollow);
}
