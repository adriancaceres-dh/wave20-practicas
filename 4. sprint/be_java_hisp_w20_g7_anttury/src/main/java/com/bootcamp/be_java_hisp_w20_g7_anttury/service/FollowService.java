package com.bootcamp.be_java_hisp_w20_g7_anttury.service;

import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7_anttury.exception.FollowAlreadyExistException;
import com.bootcamp.be_java_hisp_w20_g7_anttury.exception.UnfollowNotExistException;
import com.bootcamp.be_java_hisp_w20_g7_anttury.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g7_anttury.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w20_g7_anttury.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService implements IFollowService {

    @Autowired
    IFollowRepository followRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public String follow(int userIdFollower, int userIdFollowed) {
        Follow follow = new Follow(userIdFollower, userIdFollowed);
        boolean exists = alreadyExists(follow);
        //Se valida si ya se esta siguiendo
        if (exists) {
            throw new FollowAlreadyExistException("User is already followed");
            //Ahora se valida que no se intente seguir a si mismo
        } else if (userIdFollower == userIdFollowed) {
            throw new FollowAlreadyExistException("User cannot be followed by himself");
            //Ahora se valida que tanto el que va a seguir como el que se va a seguir existan
        } else if (userRepository.findById(userIdFollower) == null || userRepository.findById(userIdFollowed) == null) {
            throw new UserNotFoundException("Followed user or Foller user not found");
        } else {
            followRepository.save(follow);
            return "User has been followed succesfully";
        }
    }

    @Override
    public String unfollow(int userIdFollower, int userIdFollowed) {
        Follow follow = new Follow(userIdFollower, userIdFollowed);
        boolean exists = alreadyExists(follow);

        if (exists) {
            followRepository.findAll().remove(follow);
            return "the user was unfollowed successfully";
        } else {
            throw new UnfollowNotExistException("The user is not currently followed");
        }
    }

    public boolean alreadyExists(Follow follow) {
        return followRepository.findAll().stream()
                .anyMatch(f -> f.equals(follow));
    }
}
