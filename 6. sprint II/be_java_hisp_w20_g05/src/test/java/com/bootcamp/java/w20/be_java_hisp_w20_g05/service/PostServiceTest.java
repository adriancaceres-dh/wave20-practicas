package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;


import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowedUsersPostsResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IPostRepository;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IPostRepository;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowedUsersPostsResponseDTO;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    IPostRepository postRepository;
    @Mock
    UserService userService;

    @Mock
    IUserService userService;

    @InjectMocks
    PostService postService;

    @DisplayName("Test T-0005 - Order: asc - OK")
    @Test
    void verifyPerformOrderTestAscOk()
    {
        //arrange
        int userId = 1;
        String order = "date_asc";

        // Retorna un dto de FollowedUsersPostsResponseDTO con 3 posts asociados a un user ordenado ascendientemente (Expected).
        FollowedUsersPostsResponseDTO expected = TestUtils.getFollowedUsersPosts(userId);

        //Retorno usuario pepe que sigue a usuarios con id 4,5,6.
        when(userService.getById(userId)).thenReturn(TestUtils.getUserWithId(userId));

        //Cuando hace un getall de los repositorios "Simulo" obtener 3 post los cuales se envian desordenados para verificar el correcto orden.
        when(postRepository.getAll()).thenReturn(TestUtils.get3PostsWithUserId(userId));

        //act
        FollowedUsersPostsResponseDTO result = postService.getFollowedUsersPosts(userId, order);

        //assert
        List<LocalDate> expectedDates = new ArrayList<>();
        expected.getPosts().stream().forEach( e -> expectedDates.add(e.getDate()));

        List<LocalDate> resultDates = new ArrayList<>();
        result.getPosts().stream().forEach( r -> resultDates.add(r.getDate()));

        assertEquals(resultDates,expectedDates);
        assertEquals(expected.getPosts().size(), result.getPosts().size());
        verify(userService, atLeastOnce()).getById(userId);
        verify(postRepository, atLeastOnce()).getAll();
    }
    @DisplayName("Test T-0005 - Order: desc - OK")
    @Test
    void verifyPerformOrderTestDescOk()
    {
        //arrange
        int userId = 1;
        String order = "date_desc";

        // Retorna un dto de FollowedUsersPostsResponseDTO con 3 posts asociados a un user ordenados descencientemente (Expected.)
        FollowedUsersPostsResponseDTO expected = TestUtils.getFollowedUsersPostsDesc(userId);

        //Retorno usuario pepe que sigue a usuarios con id 4,5,6.
        when(userService.getById(userId)).thenReturn(TestUtils.getUserWithId(userId));

        //Cuando hace un getall de los repositorios "Simulo" obtener 3 post los cuales se envian desordenados para verificar el correcto orden.
        when(postRepository.getAll()).thenReturn(TestUtils.get3PostsWithUserId(userId));

        //act
        FollowedUsersPostsResponseDTO result = postService.getFollowedUsersPosts(userId, order);

        //assert
        List<LocalDate> expectedDates = new ArrayList<>();
        expected.getPosts().stream().forEach( e -> expectedDates.add(e.getDate()));

        List<LocalDate> resultDates = new ArrayList<>();
        result.getPosts().stream().forEach( r -> resultDates.add(r.getDate()));

        assertEquals(resultDates,expectedDates);
        assertEquals(expected.getPosts().size(), result.getPosts().size());
        verify(userService, atLeastOnce()).getById(userId);
        verify(postRepository, atLeastOnce()).getAll();
    @Test
    @DisplayName("T-0006 Ordenamiento ascendente")
    public void sortAscendingFollowedUserPosts() {
        // Arrange
        Set<Post> posts = TestUtils.createMockPosts();
        User user = new User(2, "hbowstead0", Set.of(1,3,4), Set.of(3,4));
        // Booleano que verificará ordenamiento
        boolean ordered = true;

        // Se mockea el comportamiento de los objetos mockeados
        when(userService.getById(2)).thenReturn(user);
        when(postRepository.getAll()).thenReturn(posts);

        // Se listan las publicaciones de los usuarios a los que sigue el 2, en orden ascendente
        FollowedUsersPostsResponseDTO res = postService.getFollowedUsersPosts(2, "date_asc");
        Iterator< PostResponseDTO> it = res.getPosts().iterator();
        LocalDate prevDate = it.next().getDate();
        while (it.hasNext() && ordered) {
            LocalDate nextDate = it.next().getDate();
            ordered = nextDate.isAfter(prevDate);
            prevDate = nextDate;
        }

        assertEquals(res.getUserId(), user.getId());
        assertTrue(ordered);
    }

    @Test
    @DisplayName("T-0006 Ordenamiento descendente")
    public void sortDescendingFollowedUserPosts() {
        // Arrange
        Set<Post> posts = TestUtils.createMockPosts();
        User user = new User(2, "hbowstead0", Set.of(1,3,4), Set.of(3,4));
        // Booleano que verificará ordenamiento
        boolean ordered = true;

        // Se mockea el comportamiento de los objetos mockeados
        when(userService.getById(2)).thenReturn(user);
        when(postRepository.getAll()).thenReturn(posts);

        // Se listan las publicaciones de los usuarios a los que sigue el 2, en orden ascendente
        FollowedUsersPostsResponseDTO res = postService.getFollowedUsersPosts(2, "date_desc");
        Iterator< PostResponseDTO> it = res.getPosts().iterator();
        LocalDate prevDate = it.next().getDate();
        while (it.hasNext() && ordered) {
            LocalDate nextDate = it.next().getDate();
            ordered = nextDate.isBefore(prevDate);
            prevDate = nextDate;
        }

        assertEquals(res.getUserId(), user.getId());
        assertTrue(ordered);
    }

    @Test
    @DisplayName("T-0008 cumple")
    public void getFollowedUsersPostsTest(){
        //Arrange
        int userId = 3;
        User user = new User(userId, "qropcke1", Set.of(1, 2), Set.of(2));
        String order = "date_asc";
        LocalDate currentDate = LocalDate.now();

        Mockito.when(postRepository.getAll()).thenReturn(TestUtils.createMockPosts());
        Mockito.when(userService.getById(userId)).thenReturn(user);

        //Act
        FollowedUsersPostsResponseDTO testPostsDto = postService.getFollowedUsersPosts(userId, order);
        LocalDate earliestDate = testPostsDto.getPosts().stream().findFirst().get().getDate();

        //Assert
        Assertions.assertTrue(earliestDate.isAfter(currentDate.minusDays(14)));
    }
}
