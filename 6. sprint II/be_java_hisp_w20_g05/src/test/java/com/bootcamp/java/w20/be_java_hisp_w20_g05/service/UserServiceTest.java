package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersBySellerDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IUserRepository;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.WrongRequestParamException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepository;
    @InjectMocks
    UserService userService;
    private static ObjectWriter writer;
    private AutoCloseable closeable;
    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }
    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("T-0001 cumple")
    void followUser_ok(){

        //Arrange
        int userId = 1;
        int userIdToFollow = 1213213;

        User user = new User(userId, "", new HashSet<>(), new HashSet<>());
        User userToFollow = new User(userIdToFollow, "", new HashSet<>(), new HashSet<>());

        when(userRepository.getById(userId)).thenReturn(Optional.of(user));
        when(userRepository.getById(userIdToFollow)).thenReturn(Optional.of(userToFollow));

        //Act

        userService.followUser(userId, userIdToFollow);

        //Assert
        assertTrue(user.getFollowing().contains(userIdToFollow));
        assertTrue(userToFollow.getFollowers().contains(userId));

    }
    @Test
    @DisplayName("T-0001 no cumple")
    void followUser_userNotFound(){

        //Arrange
        int userId = 1;
        int userIdToFollow = 1213213;

        User user = new User(userId, "us1", new HashSet<>(), new HashSet<>());

        when(userRepository.getById(userId)).thenReturn(Optional.of(user));
        when(userRepository.getById(userIdToFollow)).thenReturn(Optional.empty());

        String expectedMessage = "User with id: "+userIdToFollow+" was not found";

        //Act && Assert

        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
            userService.followUser(userId, userIdToFollow);
        });

        String actualMessage = exception.getMessageExceptionDto().getMessageException();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    @DisplayName("T-0002 cumple")
    void unfollowUser_ok(){
        //Arrange
        int userId = 1;
        int userIdToUnFollow = 1213213;

        User user = new User(userId, "", new HashSet<>(), new HashSet<>());
        User userToFollow = new User(userIdToUnFollow, "", new HashSet<>(userId), new HashSet<>());

        user.followUser(userIdToUnFollow);

        when(userRepository.getById(userId)).thenReturn(Optional.of(user));
        when(userRepository.getById(userIdToUnFollow)).thenReturn(Optional.of(userToFollow));

        //Act

        userService.unfollowUser(userId, userIdToUnFollow);

        //Assert
        assertFalse(user.getFollowing().contains(userIdToUnFollow));
        assertFalse(userToFollow.getFollowers().contains(userId));
    }
    @Test
    @DisplayName("T-0002 no cumple")
    void unfollowUser_userNotFound(){
        //Arrange
        int userId = 1;
        int userIdToUnFollow = 1213213;

        User user = new User(userId, "us1", new HashSet<>(), new HashSet<>());

        when(userRepository.getById(userId)).thenReturn(Optional.of(user));
        when(userRepository.getById(userIdToUnFollow)).thenReturn(Optional.empty());

        String expectedMessage = "User with id: "+userIdToUnFollow+" was not found";

        //Act && Assert

        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
            userService.unfollowUser(userId, userIdToUnFollow);
        });

        String actualMessage = exception.getMessageExceptionDto().getMessageException();

        assertTrue(actualMessage.contains(expectedMessage));
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


    // TEST T-0004
    // Verificar el correcto ordenamiento ascendente y descendente por nombre.
    @Test
    @DisplayName("T-0004: Following by name_asc")
    public void getFollowedByIdTestAsc () {

        // ARRANGE
        when(userRepository.getById(5)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(5))); // userId del usuario de test que sigue a todos y todos lo siguen.
        when(userRepository.getById(1)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(1))); // usu1
        when(userRepository.getById(2)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(2))); // hbowstead0
        when(userRepository.getById(3)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(3))); // qropcke1
        when(userRepository.getById(4)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(4))); // jmedcraft2

        FollowedListDTO expectedAscending = TestUtils.getTestFollowedListDTO("name_asc");   // hbowstead0, jmedcraft2, qropcke1, usu1
        FollowedListDTO sortedAscending;

        // ACT
        sortedAscending = userService.getFollowedListDto(5, "name_asc");

        // ASSERT
        Assertions.assertTrue(sortedAscending.equals(expectedAscending));
    }

    @Test
    @DisplayName("T-0004: Following by name_desc")
    public void getFollowedByIdTestDesc () {

        // ARRANGE
        when(userRepository.getById(5)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(5))); // userId del usuario de test que sigue a todos y todos lo siguen.
        when(userRepository.getById(1)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(1))); // usu1
        when(userRepository.getById(2)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(2))); // hbowstead0
        when(userRepository.getById(3)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(3))); // qropcke1
        when(userRepository.getById(4)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(4))); // jmedcraft2

        FollowedListDTO expectedDescending = TestUtils.getTestFollowedListDTO("name_desc"); // usu1, qropcke1, jmedcraft2, hbowstead0
        FollowedListDTO sortedDescending;

        // ACT
        sortedDescending = userService.getFollowedListDto(5, "name_desc");

        // ASSERT
        Assertions.assertTrue(sortedDescending.equals(expectedDescending));

    }

    @Test
    @DisplayName("T-0004: Followers by name_asc")
    public void getFollowersBySellerTestAsc () {
        // ARRANGE
        when(userRepository.getById(5)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(5))); // userId del usuario de test que sigue a todos y todos lo siguen.
        when(userRepository.getById(1)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(1))); // usu1
        when(userRepository.getById(2)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(2))); // hbowstead0
        when(userRepository.getById(3)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(3))); // qropcke1
        when(userRepository.getById(4)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(4))); // jmedcraft2

        FollowersBySellerDTO expectedAscending = TestUtils.getTestFollowersBySellerDTO("name_asc");   // hbowstead0, jmedcraft2, qropcke1, usu1
        FollowersBySellerDTO sortedAscending;

        // ACT
        sortedAscending = userService.getFollowersBySeller(5, "name_asc");

        // ASSERT
        Assertions.assertTrue(sortedAscending.equals(expectedAscending));
    }

    @Test
    @DisplayName("T-0004: Followers by name_desc")
    public void getFollowersBySellerTestDesc () {
        // ARRANGE
        when(userRepository.getById(5)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(5))); // userId del usuario de test que sigue a todos y todos lo siguen.
        when(userRepository.getById(1)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(1))); // usu1
        when(userRepository.getById(2)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(2))); // hbowstead0
        when(userRepository.getById(3)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(3))); // qropcke1
        when(userRepository.getById(4)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(4))); // jmedcraft2

        FollowersBySellerDTO expectedDescending = TestUtils.getTestFollowersBySellerDTO("name_desc");   // hbowstead0, jmedcraft2, qropcke1, usu1
        FollowersBySellerDTO sortedDescending;

        // ACT
        sortedDescending = userService.getFollowersBySeller(5, "name_desc");

        // ASSERT
        Assertions.assertTrue(sortedDescending.equals(expectedDescending));
    }

    // FIN DE TEST T-0004


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
    @Test
    @DisplayName("T-0007 Cantidad de Segiodores correcta")
    public void getFollowersCountTest() throws Exception {
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
