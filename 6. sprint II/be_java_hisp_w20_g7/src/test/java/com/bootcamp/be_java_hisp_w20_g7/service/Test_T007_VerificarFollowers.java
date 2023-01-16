package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w20_g7.repository.FollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g7.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.bootcamp.be_java_hisp_w20_g7.utils.TestUtils.userFollowersCountDto;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Test_T007_VerificarFollowers {

    @Mock
    UserRepository userRepository;

    @Mock
    FollowRepository followRepository;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("Test para verificar la cantidad de seguidores de un determinado usuario")
    public void verifyFollowOK() {

        //Arrange

        when(userRepository.findById(1)).thenReturn(TestUtils.users().get(0));
        when(followRepository.findAll()).thenReturn(TestUtils.userFollowsTestOK());

        //Act
        UserFollowersCountDto result = userService.countFollowers(1);

        //Assert
        Assertions.assertEquals(userFollowersCountDto.getFollowersCount(), result.getFollowersCount());

    }

}
