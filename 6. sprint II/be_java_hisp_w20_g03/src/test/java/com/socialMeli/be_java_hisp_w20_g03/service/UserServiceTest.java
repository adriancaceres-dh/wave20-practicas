package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import com.socialMeli.be_java_hisp_w20_g03.utils.UserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("US0001-Permite continuar con normalidad.")
    void addFollower() {
        //Arrange
        int idRequestUser = 234;
        int idRequestUser2 = 6631;
        User user1 = UserUtils.getUserAddFollower(idRequestUser);
        User user2 = UserUtils.getUserAddFollower(idRequestUser2);
        String expected = "Comenzaste a seguir al usuario: " + user2.getUserName();
        when(userRepository.getUserById(idRequestUser)).thenReturn(user1);
        when(userRepository.getUserById(idRequestUser2)).thenReturn(user2);
        //Act
        String result = userService.addFollower(idRequestUser,idRequestUser2);
        // assert
        Assertions.assertEquals(expected,result);
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
