package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.repository.FollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g7.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

public class Test_T004_OrderedByNameFollowed {

    @Mock
    UserRepository userRepository;

    @Mock
    FollowRepository followRepository;

    @InjectMocks
    UserService userService;


    @Test
    @DisplayName("T004 alphabetical order ascending")
    public void userFollowedOrderAscOk(){

        //Arrange
        UserFollowedDto expected = TestUtils.userFollowedTest("name_asc");
        //Act
        when(followRepository.findAll()).thenReturn(TestUtils.userFollowsTest());
        when(userRepository.findById(1)).thenReturn(TestUtils.usersTest().get(4));
        when(userRepository.findById(2)).thenReturn(TestUtils.usersTest().get(0));
        when(userRepository.findById(3)).thenReturn(TestUtils.usersTest().get(1));
        when(userRepository.findById(4)).thenReturn(TestUtils.usersTest().get(2));
        when(userRepository.findById(5)).thenReturn(TestUtils.usersTest().get(3));

        UserFollowedDto result = userService.userFollowed(1,"name_asc");

        //Assert
        Assertions.assertEquals(expected, result);


    }

    @Test
    @DisplayName("T004 alphabetical order descending")
    public void userFollowedOrderDescOk(){

        //Arrange
        UserFollowedDto expected = TestUtils.userFollowedTest("name_desc");
        //Act
        when(followRepository.findAll()).thenReturn(TestUtils.userFollowsTest());
        when(userRepository.findById(1)).thenReturn(TestUtils.usersTest().get(4));
        when(userRepository.findById(2)).thenReturn(TestUtils.usersTest().get(0));
        when(userRepository.findById(3)).thenReturn(TestUtils.usersTest().get(1));
        when(userRepository.findById(4)).thenReturn(TestUtils.usersTest().get(2));
        when(userRepository.findById(5)).thenReturn(TestUtils.usersTest().get(3));

        UserFollowedDto result = userService.userFollowed(1,"name_desc");

        //Assert
        Assertions.assertEquals(expected,result);


    }
}
