package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.util.UtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void findAllFollowers() {

        // test follow an existing user (OK)

        HashMap<Integer, User> users = UtilsTest.generateUsersToTestFollow();

        User user1 = users.get(1);
        User user2 = users.get(2);


        when(userRepository.exists(1)).thenReturn(true);
        when(userRepository.exists(2)).thenReturn(true);

        when(userRepository.findOne(1)).thenReturn(user1);
        when(userRepository.findOne(2)).thenReturn(user2);

        boolean res = userService.follow(1,2);

        verify(userRepository,atLeastOnce()).exists(1);
        verify(userRepository,atLeastOnce()).exists(2);
        verify(userRepository,atLeastOnce()).findOne(2);
        verify(userRepository,atLeastOnce()).findOne(2);

        Assertions.assertTrue(res);
    }

    @Test
    void findAllFollowed() {
    }

    @Test
    void unfollowUser() {
    }

    @Test
    void entity2UserResponseDTO() {
    }

    @Test
    void follow() {
    }

    @Test
    void followerList() {
    }
}