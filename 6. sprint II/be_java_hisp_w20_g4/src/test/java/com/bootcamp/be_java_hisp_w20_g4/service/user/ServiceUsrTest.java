package com.bootcamp.be_java_hisp_w20_g4.service.user;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4.model.Buyer;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceUsrTest {

    @Mock
    IUserRepository mockUserRepository;

    @InjectMocks
    ServiceUsr mockServiceUser;

    @Test
    void followOKTest() {
    }

    @Test
    void followInvalidIDTest() {
    }

    @Test
    void followersCountOKTest() {
    }

    @Test
    void followersOrderAscOKTest() {
    }

    @Test
    void followersOrderDescOKTest() {
    }

    @Test
    void followersInvalidOrderTest() {
    }

    @Test
    void followedOrderAscOKTest() {
    }

    @Test
    void followedOrderDescOKTest() {
    }

    @Test
    void followedInvalidOrderTest() {
    }

    @Test
    void unfollowOKTest() {
        Buyer userWhoUnfollow = new Buyer(1, "nombre1");
        Seller userUnfollowed = new Seller(2, "nombre2");
        userWhoUnfollow.addUserToMyFollowedList(userUnfollowed);
        userUnfollowed.addUserToMyFollowersList(userWhoUnfollow);

        UserFollowedDTO expected = new UserFollowedDTO(1, "nombre1", new ArrayList<>()); //No sigue a nadie

        when(mockUserRepository.findById(1)).thenReturn(userWhoUnfollow);
        when(mockUserRepository.findById(2)).thenReturn(userUnfollowed);

        UserFollowedDTO result = mockServiceUser.unfollow(1,2);

        Assertions.assertEquals(expected, result);

    }

    @Test
    void unfollowInvalidIDTest() {
    }
}