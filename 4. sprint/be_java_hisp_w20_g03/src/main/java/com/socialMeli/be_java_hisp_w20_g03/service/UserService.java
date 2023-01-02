package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

   /* @Override
    public List<UserDTO> getUsers() {
        return iUserRepository.getUsers();
    }*/

    @Override
    public ResponseEntity<String> addFollower(int userId, int userIdToFollow) {

        try{
            User currentUser = iUserRepository.getUserById(userId);
            User followUser = iUserRepository.getUserById(userIdToFollow);
            if(currentUser == null || followUser == null)
                return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
            List<User> getFollowersList = followUser.getFollowers();
            if(getFollowersList.contains(currentUser))
                return new ResponseEntity<>("You are already following the user",HttpStatus.BAD_REQUEST);
            getFollowersList.add(currentUser);
            return new ResponseEntity<>("Following", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public UserFollowerCountDTO getFollowerCount(int userId) {
        return null;
    }

    @Override
    public List<UserFollowersDTO> getFollowersList(int userId) {
        return null;
    }

    @Override
    public List<UserFollowersDTO> getFollowedList(int userId) {
        return null;
    }

    @Override
    public boolean unfollow(int userId, int UserIdToUnfollow) {
        return false;
    }
}
