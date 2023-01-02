package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService{
    @Autowired
    private IRepository<User> userRepository;

    @Override
    public List<UserResponseDTO> filterBy(String name) {
        return null;
    }

    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public boolean followUser(int userId, int userIdToFollow) {
        User user1 = userRepository.getById(userId);
        User user2 = userRepository.getById(userIdToFollow);
        //No es necesario chequear ya que el getById arroja una excepcion si no encuentra el user
        user1.followUser(user2.getId());
        user2.addFollower(user1.getId());
        return true;
    }

}
