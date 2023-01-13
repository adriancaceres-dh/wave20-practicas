package com.socialMeli.be_java_hisp_w20_g03.service;


import com.socialMeli.be_java_hisp_w20_g03.dto.request.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
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

import static com.socialMeli.be_java_hisp_w20_g03.utils.UserUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


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
    void getFollowersListOrderDesc() {
        //arrange
        int userId = 234;
        UserFollowersDTO expect = buildListUserFollowedDtoDesc();
        User user = buildtUser();
        when(userRepository.getUserById(userId)).thenReturn(user);
        //act
        UserFollowersDTO actual = userService.getFollowersList(234,"name_desc");
        //assert
        verify(userRepository, atLeastOnce()).getUserById(userId);
        assertEquals(expect,actual);
    }
    @Test
    void getFollowersListOrderAsc() {
        //arrange
        int userId = 234;
        UserFollowersDTO expect = buildListUserFollowedDtoAsc();
        User user = buildtUser();
        when(userRepository.getUserById(userId)).thenReturn(user);
        //act
        UserFollowersDTO actual = userService.getFollowersList(234,"name_asc");
        //assert
        verify(userRepository, atLeastOnce()).getUserById(userId);
        assertEquals(expect,actual);
    }

    @Test
    void getFollowedList() {
    }

    @Test
    void unfollow() {
    }
}
