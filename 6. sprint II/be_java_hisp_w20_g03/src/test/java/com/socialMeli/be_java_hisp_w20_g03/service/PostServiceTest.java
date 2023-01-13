package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.request.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.exception.BadRequestException;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialMeli.be_java_hisp_w20_g03.model.Post;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.repository.IPostRepository;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import com.socialMeli.be_java_hisp_w20_g03.repository.PostRepository;
import com.socialMeli.be_java_hisp_w20_g03.utils.PostUtils;
import com.socialMeli.be_java_hisp_w20_g03.utils.UserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    IPostRepository postRepository;

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    PostService postService;

    @Test
    @DisplayName("T-0008: Camino Feliz")
    void getPostOk() {
        //Arrange
        int userId1 = 6631;
        int userId2 = 234;
        List<Post> expectedPosts = PostUtils.getLatestPosts();
        List<PostDTO> expectedPostsDTO = PostUtils.postDTOConverter(expectedPosts);
        User user1 = User.builder()
                .userId(userId1)
                .userName("usuario1")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User user2 = User.builder()
                .userId(userId2)
                .userName("usuario2")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        user2.getFollowed().add(user1);
        user1.getFollowers().add(user2);
        when(userRepository.getUserById(userId1)).thenReturn(user2);
        when(postRepository.getPostsByUserId(userId1)).thenReturn(expectedPosts);

        //Act
        List<PostDTO> actualPosts = postService.getPost(userId1, null);

        //Assert
        verify(postRepository, atLeast(1)).getPostsByUserId(userId1);
        verify(userRepository, atLeast(1)).getUserById(userId1);
        Assertions.assertEquals(expectedPostsDTO, actualPosts);
    }

    @Test
    @DisplayName("T-0008: Verificando la excepcion cuando el usuario no existe.")
    void getPostThrowsNotFoundException() {
        //Arrange
        int userId1 = 1558;

        //Act y Assert
        Assertions.assertThrows(NotFoundException.class, () ->postService.getPost(userId1, null));
    }

    @Test
    @DisplayName("T-0006: Ordenamiento descendente correcto de publicaciones")
    void getPostDescendingOk() {
        //Arrange
        int userId1 = 6631;
        int userId2 = 234;
        List<Post> expectedPosts = PostUtils.getLatestPosts();
        List<PostDTO> expectedPostsDTO = PostUtils.postDTOConverter(expectedPosts);
        User user1 = User.builder()
                .userId(userId1)
                .userName("usuario1")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User user2 = User.builder()
                .userId(userId2)
                .userName("usuario2")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        user2.getFollowed().add(user1);
        user1.getFollowers().add(user2);
        when(userRepository.getUserById(userId1)).thenReturn(user2);
        when(postRepository.getPostsByUserId(userId1)).thenReturn(expectedPosts);

        //Act
        List<PostDTO> actualPosts = postService.getPost(userId1, "date_desc");

        //Assert
        verify(postRepository, atLeast(1)).getPostsByUserId(userId1);
        verify(userRepository, atLeast(1)).getUserById(userId1);
        Assertions.assertEquals(expectedPostsDTO, actualPosts);
    }

    @Test
    @DisplayName("T-0006: Ordenamiento descendente correcto de publicaciones")
    void getPostAscendingOk() {
        //Arrange
        int userId1 = 6631;
        int userId2 = 234;
        List<Post> expectedPosts = PostUtils.getAscendingDatePosts();
        List<PostDTO> expectedPostsDTO = PostUtils.postDTOConverter(expectedPosts);
        User user1 = User.builder()
                .userId(userId1)
                .userName("usuario1")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User user2 = User.builder()
                .userId(userId2)
                .userName("usuario2")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        user2.getFollowed().add(user1);
        user1.getFollowers().add(user2);
        when(userRepository.getUserById(userId1)).thenReturn(user2);
        when(postRepository.getPostsByUserId(userId1)).thenReturn(expectedPosts);

        //Act
        List<PostDTO> actualPosts = postService.getPost(userId1, "date_asc");

        //Assert
        verify(postRepository, atLeast(1)).getPostsByUserId(userId1);
        verify(userRepository, atLeast(1)).getUserById(userId1);
        Assertions.assertEquals(expectedPostsDTO, actualPosts);
    }

    @Test
    @DisplayName("T-0005: Parametro de ordenamiento existe")
    void testDateOrder() {
        //Arrange
        User user234 = UserUtils.buildUser();
        User user = User.builder()
                .userId(1)
                .userName("usuario1")
                .followers(new ArrayList<>())
                .followed(List.of(user234))
                .build();
        when(userRepository.getUserById(1)).thenReturn(user);

        List<Post> posts = PostUtils.getLatestPosts();
        when(postRepository.getPostsByUserId(234)).thenReturn(posts);

        //Act
        List<PostDTO> ascPost = postService.getPost(1, "date_asc");
        List<PostDTO> descPost = postService.getPost(1, "date_desc");
        //Assert
        Assertions.assertThrows(BadRequestException.class, () ->postService.getPost(1, "date_bsc"));
        Assertions.assertFalse(ascPost.isEmpty());
        Assertions.assertFalse(descPost.isEmpty());
        verify(userRepository, atLeast(1)).getUserById(1);
        verify(postRepository, atLeast(1)).getPostsByUserId(234);
    }

}