package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.WrongRequestParamException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IUserRepository;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    private static ObjectWriter writer;
    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    /*
    Verifica unicamente que el ordenamiento alfabetico exista, y que la ejecucion no lance una excepcion
    por el solo hecho de pasar el test. No necesariamente que el ordenamiento sea correcto. El metodo que
    ordena la lista es privado asi que tampoco se puede hacer un verify de que se ejecuta, lo unico que se
    me ocurrio es comprobar que la lista sufrio un cambio con el assertNotEquals.
    */
    @Test
    @DisplayName("T-0003 Followed_Ord_Desc_Exists")
    public void getFollowedListDtoTestOrderDescExists() throws Exception{
        //Arrange
        int id=1;
        String order="naME_DeSc";
        String original = writer.writeValueAsString(TestUtils.createFollsListDto(id,true));

        when(userRepository.getById(id)).thenReturn(Optional.of(new User(id,"usu1",null, Set.of(2,3,4))));
        when(userRepository.getById(2)).thenReturn(Optional.of(new User(2,"hbowstead0",null,null)));
        when(userRepository.getById(3)).thenReturn(Optional.of(new User(3,"qropcke1",null,null)));
        when(userRepository.getById(4)).thenReturn(Optional.of(new User(4,"jmedcraft2",null,null)));
        //Act
        String ordered = writer.writeValueAsString(userService.getFollowedListDto(id, order).getFollowed());
        //Assert
        Assertions.assertNotEquals(original,ordered);
    }

    @Test
    @DisplayName("T-0003 Followed_Ord_Asc_Exists")
    public void getFollowedListDtoTestOrderAscExists() throws Exception{
        //Arrange
        int id=1;
        String order="naME_aSc";
        String original = writer.writeValueAsString(TestUtils.createFollsListDto(id,true));

        when(userRepository.getById(id)).thenReturn(Optional.of(new User(id,"usu1",null,Set.of(2,3,4))));
        when(userRepository.getById(2)).thenReturn(Optional.of(new User(2,"hbowstead0",null,null)));
        when(userRepository.getById(3)).thenReturn(Optional.of(new User(3,"qropcke1",null,null)));
        when(userRepository.getById(4)).thenReturn(Optional.of(new User(4,"jmedcraft2",null,null)));
        //Act
        String ordered = writer.writeValueAsString(userService.getFollowedListDto(id, order).getFollowed());
        //Assert
        Assertions.assertNotEquals(original,ordered);
    }

    @Test
    @DisplayName("T-0003 Followed_Order_Empty_list")
    public void getFollowedListDtoTestEmptyList() throws Exception{
        //Arrange
        int id=123;
        String order="NAmE_aSC";
        when(userRepository.getById(id)).thenReturn(Optional.of(new User(id,"user",null,Set.of())));
        //Act
        String ordered = writer.writeValueAsString(userService.getFollowedListDto(id,order).getFollowed());
        //Assert
        Assertions.assertEquals("[]",ordered);
    }

    @Test
    @DisplayName("T-0003 Followed_Order_Exception")
    public void getFollowedListDtoTestWrongOrderException(){
        //Arrange
        int id=1;
        String order="wrong_order";
        //Act & Assert
        Assertions.assertThrows(WrongRequestParamException.class,()->userService.getFollowedListDto(id,order));
    }

    @Test
    @DisplayName("T-0003 Followers_Ord_Desc_Exists")
    public void getFollowersBySellerTestOrderDescExists() throws Exception{
        //Arrange
        int id=1;
        String order="naME_DeSc";
        String original = writer.writeValueAsString(TestUtils.createFollsListDto(id,false));

        when(userRepository.getById(id)).thenReturn(Optional.of(new User(id,"usu1",Set.of(2,4),null)));
        when(userRepository.getById(2)).thenReturn(Optional.of(new User(2,"hbowstead0",null,null)));
        when(userRepository.getById(4)).thenReturn(Optional.of(new User(4,"jmedcraft2",null,null)));
        //Act
        String ordered = writer.writeValueAsString(userService.getFollowersBySeller(id, order).getFollowers());
        //Assert
        Assertions.assertNotEquals(original,ordered);
    }

    @Test
    @DisplayName("T-0003 Followers_Ord_Asc_Exists")
    public void getFollowersBySellerTestOrderAscExists() throws Exception{
        //Arrange
        int id=1;
        String order="naME_aSc";
        List<UserResponseDTO> folls= new ArrayList<>(){{//El metodo en el servicio crea la lista ya ordenada por nombre ascendentemente asi que no pude seguir usando el metodo del utils para crear la lista y comparar. Crear otro metodo en utils por solo dos lineas me parecio innecesario.
            add(new UserResponseDTO(4,"jmedcraft2"));
            add(new UserResponseDTO(2,"hbowstead0")); }};
        String original = writer.writeValueAsString(folls);

        when(userRepository.getById(id)).thenReturn(Optional.of(new User(id,"usu1",Set.of(2,4),null)));
        when(userRepository.getById(2)).thenReturn(Optional.of(new User(2,"hbowstead0",null,null)));
        when(userRepository.getById(4)).thenReturn(Optional.of(new User(4,"jmedcraft2",null,null)));
        //Act
        String ordered = writer.writeValueAsString(userService.getFollowersBySeller(id, order).getFollowers());
        //Assert
        Assertions.assertNotEquals(original,ordered);
    }

    @Test
    @DisplayName("T-0003 Followers_Order_Empty_list")
    public void getFollowersBySellerTestEmptyList() throws Exception{
        //Arrange
        int id=123;
        String order="NAmE_aSC";
        when(userRepository.getById(id)).thenReturn(Optional.of(new User(id,"user",Set.of(),null)));
        //Act
        String ordered = writer.writeValueAsString(userService.getFollowersBySeller(id,order).getFollowers());
        //Assert
        Assertions.assertEquals("[]",ordered);
    }

    @Test
    @DisplayName("T-0003 Followers_Order_Exception")
    public void getFollowersBySellerTestWrongOrderException(){
        //Arrange
        int id=1;
        String order="wrong_order";
        //Act & Assert
        Assertions.assertThrows(WrongRequestParamException.class,()->userService.getFollowersBySeller(id,order));
    }

}
