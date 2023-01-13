package com.bootcamp.be_java_hisp_w20_g4.service.user;

import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    void unfollowInvalidIDTest() {
    }
}