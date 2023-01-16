package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IUserRepository;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("T-0007 Cantidad de Segiodores correcta")
    public void getFollowersCountTest() throws Exception{
        //arrange
        Set<User> users = TestUtils.createMockUsers();
        Optional<User> user1 = users.stream().findFirst();
        when(userRepository.getById(user1.get().getId())).thenReturn(user1);
        //act
        FollowersCountDTO followersCountDTO = userService.getFollowersCount(user1.get().getId());
        //verify
        verify(userRepository, atLeastOnce()).getById(user1.get().getId());
        assertEquals(user1.get().getFollowers().size(), followersCountDTO.getFollowers_count());
    }
}
