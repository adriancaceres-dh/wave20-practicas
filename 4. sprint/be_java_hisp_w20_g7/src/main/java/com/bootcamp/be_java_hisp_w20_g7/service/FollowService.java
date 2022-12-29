package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.exception.FollowAlreadyExistException;
import com.bootcamp.be_java_hisp_w20_g7.repository.FollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.IFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService implements IFollowService{

    @Autowired
    IFollowRepository followRepository;

    @Override
    public String follow(int userIdFollower, int userIdFollowed) {
        Follow follow = new Follow(userIdFollower,userIdFollowed);
        boolean exists = alreadyExists(follow);
        if(!exists){
            followRepository.save(follow);
            return "El usuario con id: " + userIdFollower + " empezo a seguir al usuario con id: " + userIdFollowed;
        }else{
            throw new FollowAlreadyExistException("No se puede seguir al usuario con id: " + userIdFollowed +" porque ya se esta siguiendo");
        }
    }

    @Override
    public String unfollow(int userIdFollower, int userIdFollowed) {
        return null;
    }

    public boolean alreadyExists(Follow follow){
        return followRepository.findAll().stream()
                .map(f -> f.equals(follow))
                .findFirst().orElse(false);
    }
}
