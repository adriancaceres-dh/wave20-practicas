package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.UserDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersDto;
import com.bootcamp.be_java_hisp_w20_g7.repository.FollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g7.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Test_T003_US003_OrderedFollowers {

    @Mock
    FollowRepository followRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;


    @Test
    public void userFollowerdOrderAscOk(){

        //Arrange
        UserFollowersDto expectedUserFollowersDto = TestUtils.userFollowersDtoTest("name_asc");
        //Act
        when(followRepository.findAll()).thenReturn(TestUtils.userFollowsTest());
        when(userRepository.findById(1)).thenReturn(TestUtils.usersTest().get(4));
        when(userRepository.findById(2)).thenReturn(TestUtils.usersTest().get(0));
        when(userRepository.findById(3)).thenReturn(TestUtils.usersTest().get(1));
        when(userRepository.findById(4)).thenReturn(TestUtils.usersTest().get(2));
        when(userRepository.findById(5)).thenReturn(TestUtils.usersTest().get(3));

        UserFollowersDto actualUserFollowersDto = userService.userFollowers(1,"name_asc");

        System.out.println(expectedUserFollowersDto);
        System.out.println(actualUserFollowersDto);

        //Assert
        Assertions.assertEquals(expectedUserFollowersDto,actualUserFollowersDto);


    }
}
