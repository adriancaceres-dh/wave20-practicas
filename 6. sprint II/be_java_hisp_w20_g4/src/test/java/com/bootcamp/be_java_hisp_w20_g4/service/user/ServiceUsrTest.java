package com.bootcamp.be_java_hisp_w20_g4.service.user;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowersDTO;
import com.bootcamp.be_java_hisp_w20_g4.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.model.Buyer;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceUsrTest {

    @Mock
    IUserRepository mockUserRepository;

    @InjectMocks
    ServiceUsr mockServiceUser;

    @Test
    @DisplayName("T-0001 Verificar que el usuario a seguir exista")
    void followOKTest() {
        // arrange
        Buyer userFollow = new Buyer(1, "user which follows");
        Seller sellerToFollow = new Seller(2, "userTofollow");
        when(mockUserRepository.findById(userFollow.getUser_id())).thenReturn(userFollow);
        when(mockUserRepository.findById(sellerToFollow.getUser_id())).thenReturn(sellerToFollow);

        List<ListedUserDTO> followedExpected = List.of(new ListedUserDTO(sellerToFollow.getUser_id(),sellerToFollow.getUser_name()));
        UserFollowedDTO expected = new UserFollowedDTO(userFollow.getUser_id(),userFollow.getUser_name(), followedExpected);

        // act
        UserFollowedDTO result = mockServiceUser.follow(userFollow.getUser_id(), sellerToFollow.getUser_id());

        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("T-0001 Verificar que el usuario a seguir no existe. Lanza excepción")
    void followInvalidIDTest() {
        // arrange
        Buyer userFollow = new Buyer(1, "user which follows");
        Seller sellerToFollow = new Seller(2, "userTofollow");
        when(mockUserRepository.findById(userFollow.getUser_id())).thenReturn(userFollow);
        when(mockUserRepository.findById(sellerToFollow.getUser_id())).thenReturn(null);

        // act && assert
        Assertions.assertThrows(BadRequestException.class, () ->{mockServiceUser.follow(userFollow.getUser_id(), sellerToFollow.getUser_id());});
    }

    @Test
    @DisplayName("T-0007 - Verificar la cantidad de seguidores")
    void followersCountOKTest() {
        //arrange
        Seller seller = new Seller(1,"rodri");
        seller.addUserToMyFollowersList(new Buyer(2, "nina"));
        seller.addUserToMyFollowersList(new Buyer(3, "ani"));
        seller.addUserToMyFollowersList(new Buyer(4, "nino"));
        UserCountDTO expected = new UserCountDTO(1, "rodri", 3);
        when(mockUserRepository.findById(1)).thenReturn(seller);
        //act
        UserCountDTO result = mockServiceUser.followersCount(1);
        //assert
        assertEquals(expected, result);
    }


    private Seller createSeller(){
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
        return seller1;

    }

    @Test
    @DisplayName("T-0003 - Verificar que el orden exista. Orden name_asc")
    void followersOrderAscOKTest() {
        //arrange
    String order = "name_asc";
    List<ListedUserDTO> expectedList = new ArrayList<>();

    UserFollowersDTO expected = new UserFollowersDTO(2,"rodri", expectedList);
    when(mockUserRepository.findById(2)).thenReturn(new Seller(2, "rodri"));
         //act
   UserFollowersDTO actual = mockServiceUser.followers(2, "name_asc");

        //assert
   Assertions.assertEquals(expected, actual);

    }
    @Test
    @DisplayName("T-0003 - Verificar que el orden exista. Orden name_desc")
    void followersOrderDescOKTest() {
        //arrange
        String order = "name_desc";

        List<ListedUserDTO> expectedList = new ArrayList<>();
        UserFollowersDTO expected = new UserFollowersDTO(2,"rodri",expectedList);

        when(mockUserRepository.findById(2)).thenReturn(new Seller(2, "rodri"));

        //act
        UserFollowersDTO result = mockServiceUser.followers(2, order);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("T-0003 - Verificar que el orden exista. Orden inválido")
    void followersInvalidOrderTest() {

        //arrange
        String wrongOrder = "lalala";

        //assert
       assertThrows(BadRequestException.class, ()->mockServiceUser.followers(1, wrongOrder));

    }

    @Test
    @DisplayName("T-0004 - Verificar el ordenamiento ascendente por nombre")
    void followedOrderAscOKTest() {
        Seller sellerCreate = createSeller();

        List<ListedUserDTO> expectedList = new ArrayList<>();
        expectedList.add(new ListedUserDTO(10,"Daniela"));
        expectedList.add(new ListedUserDTO(7,"Julieta"));
        expectedList.add(new ListedUserDTO(6,"Tammi"));

        UserFollowedDTO expected =  new UserFollowedDTO(1,"rodri",expectedList);

        when(mockUserRepository.findById(1)).thenReturn(sellerCreate);

        UserFollowedDTO result = mockServiceUser.followed(1,"name_asc");

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("T-0004 - Verificar el ordenamiento descendente por nombre")
    void followedOrderDescOKTest() {
        Seller sellerCreate = createSeller();
        List<ListedUserDTO> expectedList = new ArrayList<>();
        expectedList.add(new ListedUserDTO(6,"Tammi"));
        expectedList.add(new ListedUserDTO(7,"Julieta"));
        expectedList.add(new ListedUserDTO(10,"Daniela"));

        UserFollowedDTO expected =  new UserFollowedDTO(1,"rodri",expectedList);

        when(mockUserRepository.findById(1)).thenReturn(sellerCreate);

        UserFollowedDTO result = mockServiceUser.followed(1,"name_desc");

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("UT-0003 - Verificar que el orden exista. Orden inválido")
    void followedInvalidOrderTest() {
        assertThrows(BadRequestException.class, ()-> mockServiceUser.followed(1, "aaa") );
    }

    @Test
    @DisplayName("T-0002 -  verificar que el usuario a dejar de seguir exista")
    void unfollowOKTest() {
        //arrange
        Buyer userWhoUnfollow = new Buyer(1, "nombre1");
        Seller userUnfollowed = new Seller(2, "nombre2");
        userWhoUnfollow.addUserToMyFollowedList(userUnfollowed);
        userUnfollowed.addUserToMyFollowersList(userWhoUnfollow);

        UserFollowedDTO expected = new UserFollowedDTO(1, "nombre1", new ArrayList<>());

        when(mockUserRepository.findById(1)).thenReturn(userWhoUnfollow);
        when(mockUserRepository.findById(2)).thenReturn(userUnfollowed);
        //act
        UserFollowedDTO result = mockServiceUser.unfollow(1,2);
        //assert
        assertEquals(expected, result);

    }

    @Test
    @DisplayName("T-0002 -  verificar que el usuario a dejar de seguir exista")
    void unfollowInvalidIDTest() {
        //arrange
        Buyer userWhoUnfollow = new Buyer(1, "nombre1");

        when(mockUserRepository.findById(1)).thenReturn(userWhoUnfollow);
        when(mockUserRepository.findById(2)).thenReturn(null);
        //act & assert
        assertThrows(BadRequestException.class, () -> mockServiceUser.unfollow(1, 2));
    }
}