package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(){

    }

    public User findUser(int userIdFind){
        User userFind = userRepository.findOne(userIdFind);
        return userFind;
    }

    @Override
    public void saveUser(User user){
        userRepository.save(user);
    }
}
