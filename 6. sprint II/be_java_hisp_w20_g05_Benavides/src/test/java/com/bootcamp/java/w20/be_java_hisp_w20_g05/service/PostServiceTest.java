package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

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
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowedUsersPostsResponseDTO;
import java.time.LocalDate;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    IPostRepository postRepository;

    @Mock
    UserService userService;

    @InjectMocks
    PostService postService;

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
