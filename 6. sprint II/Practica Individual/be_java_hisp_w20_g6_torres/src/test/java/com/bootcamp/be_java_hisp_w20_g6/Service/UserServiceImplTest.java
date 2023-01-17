package com.bootcamp.be_java_hisp_w20_g6.Service;

import com.bootcamp.be_java_hisp_w20_g6.dto.response.FollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.UserResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.exception.InvalidParamException;
import com.bootcamp.be_java_hisp_w20_g6.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g6.model.UserModel;
import com.bootcamp.be_java_hisp_w20_g6.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g6.service.Implement.UserServiceImpl;
import com.bootcamp.be_java_hisp_w20_g6.util.TestsUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository mockUserRepository;

    @InjectMocks
    UserServiceImpl mockUserServiceImpl;

    @Test
    @DisplayName("US0002 - T-00007,  Verificar que la cantidad de seguidores de un determinado usuario sea correcta.")
    void shoudlGetFollowersCountOk() {
        //arrange
        int id = 1;
        UserModel user = TestsUtilsGenerator.getUserWithFollowers(id-1);
        when(mockUserRepository.getUserById(id)).thenReturn(user);
        //act
        FollowersCountResponseDto actual = mockUserServiceImpl.getFollowersCount(id);
        //assert
        assertEquals(2, actual.getFollowers_count());
    }

    @Test
    @DisplayName("US0001 - T-0001, Verificar que el usuario a seguir exista. Camino Feliz :D")
    void shouldValidateUserFollowed(){
        //arrange
        UserModel user = TestsUtilsGenerator.getUserWithOutFollowers(0);
        UserModel userToFollow = TestsUtilsGenerator.getUserWithOutFollowers(1);
        when(mockUserRepository.getUserById(1)).thenReturn(user);
        when(mockUserRepository.getUserById(2)).thenReturn(userToFollow);
        //act
        boolean actual = mockUserServiceImpl.followUser(user.getUser_id(), userToFollow.getUser_id());
        //assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("US0001 - T-0001, Verificar que el usuario a seguir no existe. Camino Muy triste :'(")
    void shouldThrowUserNotFound(){
        //arrange
        when(mockUserRepository.getUserById(9999)).thenReturn(null);
        //act
        //assert
        assertThrows(UserNotFoundException.class, ()->mockUserServiceImpl.followUser(2, 9999));
    }

    @Test
    @DisplayName("US0007 - T-0002, Verificar que el usuario a dejar de seguir exista.")
    void shouldValidateUserUnFollowed(){
        //arrange
        UserModel user1=TestsUtilsGenerator.getUserWithFollowers(0);
        UserModel user2=TestsUtilsGenerator.getUserWithFollowers(1);
        when(mockUserRepository.getUserById(1)).thenReturn(user1);
        when(mockUserRepository.getUserById(2)).thenReturn(user2);
        //act
        boolean result = mockUserServiceImpl.unFollowUser(1,2);
        //assert
        assertTrue(result);
    }
    @Test
    @DisplayName("US0007 - T-0002, Verificar que el usuario a dejar de seguir no exista.")
    void shouldValidateUserNotUnFollowed(){
        //arrange
        when(mockUserRepository.getUserById(7)).thenReturn(null);
        //act
        //assert
        assertThrows(UserNotFoundException.class, ()-> mockUserServiceImpl.unFollowUser(1,7));

    }
    @Test
    @DisplayName("US0008 - T-0003, Verificar que el tipo de ordenamiento alfabético exista (US-0008). Camino Feliz")
    void shouldContinueSort(){
        //arrange
        List<UserResponseDto> listUsers=TestsUtilsGenerator.getListUserRespondeDTOWithFollowers();
        String typeSort="name_asc";
        //act
        List<UserResponseDto> response =mockUserServiceImpl.orderReturnValues(listUsers,typeSort);
        //assert
        assertInstanceOf(List.class,response);

    }

    @Test
    @DisplayName("US0008 - T-0003, Verificar que el tipo de ordenamiento alfabético exista (US-0008). Camino Ordenamiento no existe")
    void shouldHandleNameOrderException(){
        //arrange
        List<UserResponseDto> listUsers=TestsUtilsGenerator.getListUserRespondeDTOWithFollowers();
        String typeSort="orderInverse";
        //act and assert
        assertThrows(InvalidParamException.class,
                ()->mockUserServiceImpl.orderReturnValues(listUsers,typeSort));
    }

    @Test
    @DisplayName("US-0008 - T-0004, Verificar el correcto ordenamiento ascendente por nombre")
    void shouldValidateOrderList(){

        //arrange

        String typeSort="name_asc";
        List<UserResponseDto> listUsers=TestsUtilsGenerator.getListUserRespondeDTOWithFollowers();

        //act
        List<UserResponseDto> response =mockUserServiceImpl.orderReturnValues(listUsers,typeSort);
        //assert

        assertEquals("Daniela",response.get(0).getUser_name());
        assertEquals("David",response.get(1).getUser_name());

    }

    @Test
    @DisplayName("US-0008 - T-0004, Verificar el correcto ordenamiento descendente por nombre")
    void shouldValidateDescList(){

        //arrange

        String typeSort="name_desc";
        List<UserResponseDto> listUsers=TestsUtilsGenerator.getListUserRespondeDTOWithFollowers();

        //act
        List<UserResponseDto> response =mockUserServiceImpl.orderReturnValues(listUsers,typeSort);
        //assert

        assertEquals("Diana",response.get(0).getUser_name());
        assertEquals("David",response.get(1).getUser_name());

    }

}