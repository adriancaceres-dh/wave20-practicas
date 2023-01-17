package com.bootcamp.be_java_hisp_w20_g6.Service;


import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6.exception.InvalidParamException;
import com.bootcamp.be_java_hisp_w20_g6.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g6.service.Implement.PostServiceImpl;
import com.bootcamp.be_java_hisp_w20_g6.service.Implement.UserServiceImpl;
import com.bootcamp.be_java_hisp_w20_g6.util.TestsUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @Mock
    PostRepository mockPostRepository;

    @Mock
    UserServiceImpl mockUserService;
    @InjectMocks
    PostServiceImpl mockPostServiceImpl;


    @Test
    @DisplayName("US-0009 - T-0005, Verificar el correcto ordenamiento por fecha")
    void shouldValidateOrderList(){

        //arrange
        List<PostResponseDTO> listPost = TestsUtilsGenerator.getPostsDto();

        //act
        List<PostResponseDTO> response = mockPostServiceImpl.returnOrderPostByDate(listPost,"date_asc");
        //assert

        assertInstanceOf(List.class, response);
    }

    @Test
    @DisplayName("US-0009 - T-0005, Verficar la no existencia del ordenamiento")
    void shouldHandleInvalidOrderException(){
        //arrange
        List<PostResponseDTO> listPost = TestsUtilsGenerator.getPostsDto();
        String typeSort = "orderInverse";
        //act and assert
        assertThrows(InvalidParamException.class,
                ()->mockPostServiceImpl.returnOrderPostByDate(listPost, typeSort));
    }

    @Test
    @DisplayName("US-0009 - T-0006, Verificar el correcto ordenamiento ascendente")
    void shouldSortByDateAsc() {
        //arrange2023
        String typeSort="date_asc";
        List<PostResponseDTO> listPosts=TestsUtilsGenerator.getPostsDto();
        //act
        List<PostResponseDTO> response =mockPostServiceImpl.returnOrderPostByDate(listPosts, typeSort);
        //assert
        assertEquals(LocalDate.of(2022,1,1),response.get(0).getDate());
        assertEquals(LocalDate.now().minusDays(4),response.get(1).getDate());
    }
    @Test
    @DisplayName("US-0009 - T-0006, Verificar el correcto ordenamiento descendente")
    void shouldSortByDateDesc() {
        //arrange
        String typeSort="date_desc";
        List<PostResponseDTO> listPosts=TestsUtilsGenerator.getPostsDto();
        //act
        List<PostResponseDTO> response =mockPostServiceImpl.returnOrderPostByDate(listPosts, typeSort);
        //assert
        assertEquals(LocalDate.now(),response.get(0).getDate());
        assertEquals(LocalDate.now().minusDays(2),response.get(1).getDate());
    }

    @Test
    @DisplayName("US-0009 - T-0008, Verificar que en efecto devuelva publicaciones de las ultimas dos semanas")
    void shouldReturnPostsBeforeTwoWeeks() {
        //arrange
        int lengthExpected = 3;
        when(mockUserService.getUserById(1)).thenReturn(TestsUtilsGenerator.getUserWithFollowers(2));
        when(mockPostRepository.getPostList()).thenReturn(TestsUtilsGenerator.getPostsModel());
        //act
        PostListResponseDTO after = mockPostServiceImpl.postFollowedLastWeeks(1,null);
        //assert
        assertEquals(lengthExpected, after.getPosts().size());
    }
}
