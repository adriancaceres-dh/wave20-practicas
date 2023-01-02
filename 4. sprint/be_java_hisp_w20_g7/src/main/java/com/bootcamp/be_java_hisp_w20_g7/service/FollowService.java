package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.exception.FollowAlreadyExistException;
import com.bootcamp.be_java_hisp_w20_g7.exception.UnfollowNotExistException;
import com.bootcamp.be_java_hisp_w20_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g7.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.IUserRepository;
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
            throw new FollowAlreadyExistException("No se puede seguir al usuario con id: " + userIdFollowed + " porque ya se esta siguiendo");
        //Ahora se valida que no se intente seguir a si mismo
        } else if (userIdFollower == userIdFollowed) {
            throw new FollowAlreadyExistException("El usuario no se puede seguir a si mismo");
        //Ahora se valida que tanto el que va a seguir como el que se va a seguir existan
        } else if(userRepository.findById(userIdFollower) == null || userRepository.findById(userIdFollowed) == null){
            throw new UserNotFoundException("El usuario que sigue o el que se desea seguir no existe");
        } else {
            followRepository.save(follow);
            return "El usuario con id: " + userIdFollower + " empezo a seguir al usuario con id: " + userIdFollowed;
        }
    }

    @Override
    public String unfollow(int userIdFollower, int userIdFollowed) {
        Follow follow = new Follow(userIdFollower, userIdFollowed);
        boolean exists = alreadyExists(follow);

        if(exists){
            followRepository.findAll().remove(follow);
            return "El usuario con id " + userIdFollower + " dejo de seguir al usuario con id: " + userIdFollowed;
        }else{
            throw new UnfollowNotExistException("No se pudo dejar de seguir al usuario. Probablemente actualmente no lo sigue");
        }
    }

    public boolean alreadyExists(Follow follow) {
        return followRepository.findAll().stream()
                .anyMatch(f -> f.equals(follow));
    }
}
