package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.util.UtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void findAllFollowers() {


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
        verify(userRepository,atLeastOnce()).findOne(1);
        verify(userRepository,atLeastOnce()).findOne(2);

        Assertions.assertTrue(res);
    }

    @Test
    void followerList() {
    }

    @Test
    void findAllFollowersNameOrderAscOkTest() {
        //arrange
        Optional<String> order = Optional.of("name_asc");
        HashMap<Integer, User> users = UtilsTest.generateUsersToTestFollow();
        User user1 = users.get(1);
        when(userRepository.findOne(1)).thenReturn(user1);

        List<UserResponseDTO> userResponseDTOListExpected = new ArrayList<>();
        UserResponseDTO userResponseDTO2 = new UserResponseDTO(2, "usuario2");
        UserResponseDTO userResponseDTO3 = new UserResponseDTO(3, "usuario3");
        userResponseDTOListExpected.add(userResponseDTO2);
        userResponseDTOListExpected.add(userResponseDTO3);

        UserFollowersResponseDTO userFollowedResponseDTO = new UserFollowersResponseDTO(user1.getId(), user1.getUserName(), userResponseDTOListExpected);
        //act
        UserFollowersResponseDTO userFollowedResponseDTOResult = userService.findAllFollowers(userFollowedResponseDTO.getUserId(), order);
        //assert
        assertEquals(userResponseDTOListExpected, userFollowedResponseDTOResult.getFollowers());
    }

    @Test
    void findAllFollowersNameOrderDescOkTest() {
        //arrange
        Optional<String> order = Optional.of("name_desc");
        HashMap<Integer, User> users = UtilsTest.generateUsersToTestFollow();
        User user1 = users.get(1);
        when(userRepository.findOne(1)).thenReturn(user1);

        List<UserResponseDTO> userResponseDTOListExpected = new ArrayList<>();
        UserResponseDTO userResponseDTO3 = new UserResponseDTO(3, "usuario3");
        UserResponseDTO userResponseDTO2 = new UserResponseDTO(2, "usuario2");
        userResponseDTOListExpected.add(userResponseDTO3);
        userResponseDTOListExpected.add(userResponseDTO2);

        UserFollowersResponseDTO userFollowedResponseDTO = new UserFollowersResponseDTO(user1.getId(), user1.getUserName(), userResponseDTOListExpected);
        //act
        UserFollowersResponseDTO userFollowedResponseDTOResult = userService.findAllFollowers(userFollowedResponseDTO.getUserId(), order);
        //assert
        assertEquals(userResponseDTOListExpected, userFollowedResponseDTOResult.getFollowers());
    }

    @Test
    void findAllFollowersUserNotFoundTest() {
        //arrange
        Optional<String> order = Optional.of("name_desc");
        HashMap<Integer, User> users = UtilsTest.generateUsersToTestFollow();
        User user1 = users.get(1);
        when(userRepository.findOne(1)).thenReturn(null);
        //act - assert
        assertThrows(UserNotFoundException.class, ()->userService.findAllFollowers(1,order));
    }


}