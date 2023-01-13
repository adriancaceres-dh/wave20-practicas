package com.socialMeli.be_java_hisp_w20_g03.service;


import com.socialMeli.be_java_hisp_w20_g03.dto.request.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


import static com.socialMeli.be_java_hisp_w20_g03.utils.UserUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


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
    void getFollowersListOrderDesc() {
        //arrange
        int userId = 234;
        UserFollowersDTO expect = buildListUserFollowedDtoDesc();
        User user = buildUser();
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
        User user = buildUser();
        when(userRepository.getUserById(userId)).thenReturn(user);
        //act
        UserFollowersDTO actual = userService.getFollowersList(234,"name_asc");
        //assert
        verify(userRepository, atLeastOnce()).getUserById(userId);
        assertEquals(expect,actual);
    }
    @Test
    void getFollowersListUserNotFound() {
        //arrange
        when(userRepository.getUserById(000)).thenThrow(NotFoundException.class);
        //assert
        assertThrows(NotFoundException.class, ()->userService.getFollowersList(000,null));
    }

    @Test
    void getFollowedList() {
    }

    @Test
    void unfollow() {
    }
}