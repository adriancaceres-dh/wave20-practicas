package com.bootcamp.be_java_hisp_w20_g4.service.user;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowedDTO;
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
import java.util.List;

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
        Seller seller1 = new Seller();
        seller1.setUser_name("rodri");
        seller1.setUser_id(1);

        Seller seller2 = new Seller();
        seller2.setUser_name("Tammi");
        seller2.setUser_id(6);

        Seller seller3 = new Seller();
        seller3.setUser_name("Daniela");
        seller3.setUser_id(10);

        Seller seller4 = new Seller();
        seller4.setUser_name("Julieta");
        seller4.setUser_id(7);

        HashMap<Integer, User> followed = new HashMap<>();
        followed.put(6,seller2);
        followed.put(7,seller3);
        followed.put(10,seller4);

        seller1.setFollowed(followed);

        List<ListedUserDTO> expectedList = new ArrayList<>();
        expectedList.add(new ListedUserDTO(10,"Daniela"));
        expectedList.add(new ListedUserDTO(7,"Julieta"));
        expectedList.add(new ListedUserDTO(6,"Tammi"));

        UserFollowedDTO expected =  new UserFollowedDTO(1,"rodri",expectedList);

        when(mockUserRepository.findById(1)).thenReturn(seller1);

        UserFollowedDTO result = mockServiceUser.followed(1,"name_asc");

        Assertions.assertEquals(expected,result);

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