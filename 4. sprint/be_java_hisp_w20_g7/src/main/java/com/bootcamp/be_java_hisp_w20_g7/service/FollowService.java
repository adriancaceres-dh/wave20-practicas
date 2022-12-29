package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.exception.FollowAlreadyExistException;
import com.bootcamp.be_java_hisp_w20_g7.repository.FollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.IFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FollowService implements IFollowService{

    @Autowired
    IFollowRepository followRepository;

    @Override
    public String follow(int userIdFollower, int userIdFollowed) {
        Follow follow = new Follow(userIdFollower,userIdFollowed);
        boolean exists = alreadyExists(follow);
        if(exists){
            throw new FollowAlreadyExistException("No se puede seguir al usuario con id: " + userIdFollowed +" porque ya se esta siguiendo");
        }else if (userIdFollower == userIdFollowed){
            throw new FollowAlreadyExistException("El usuario no se puede seguir a si mismo");
        }else{
            followRepository.save(follow);
            return "El usuario con id: " + userIdFollower + " empezo a seguir al usuario con id: " + userIdFollowed;
        }
    }

    @Override
    public String unfollow(int userIdFollower, int userIdFollowed) {
        return null;
    }

    public boolean alreadyExists(Follow follow){
        return followRepository.findAll().stream()
                .anyMatch(f -> f.equals(follow));
    }
}
