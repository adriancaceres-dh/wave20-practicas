package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void addFollower() {
    }

    @Test
    void getFollowerCount() {
    }

    @Test
    void getFollowersList() {
    }

    @Test
    void getFollowedList() {
    }

    @Test
    void unfollow() {
    }
}