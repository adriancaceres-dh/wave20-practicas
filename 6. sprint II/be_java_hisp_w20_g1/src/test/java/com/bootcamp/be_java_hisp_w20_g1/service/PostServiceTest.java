package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.exception.InvalidQueryParamValueException;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g1.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private ProductService productService;

    @Mock
    private UserService userService;

    @InjectMocks
    PostService postService;

    ModelMapper mapper = new ModelMapper();

    @Test
    void lastTwoWeeksPostsFromFollowersTest() {
        //Arrange
        Set<Integer> followedIds = new HashSet<>();

        //variables de test
        int idUser = 2;
        int idSeller = 1;
        int idFirstExpectedProduct=1;
        int idSecondExpectedProduct=2;
        String order = Parameter.getString("DateDesc");
        followedIds.add(idSeller);

        //lista de id de posts
        List<Post> posts = TestUtil.getPostsByUserId(idSeller);
        //populamiento de lista
        ProductResponseDto firstExpectedProduct = TestUtil.getProductById(idFirstExpectedProduct);
        ProductResponseDto secondExpecterdProduct = TestUtil.getProductById(idSecondExpectedProduct);

        //se valida que el usuario exista
        when(userService.validateUserExistById(idUser)).thenReturn(true);

        //devuelve la lista de ids de los vendedores a los cuales sigue el usuario
        when(userService.getUserFollowed(idUser)).thenReturn(followedIds);

        //devuelve la lista de posteos del vendedor
        when(postRepository.getPostsByUserId(idSeller)).thenReturn(posts);

        //devuelve los productos asociados a cada posteo.
        when(productService.getProductById(1)).thenReturn(firstExpectedProduct);
        when(productService.getProductById(2)).thenReturn(secondExpecterdProduct);

        PostListResponseDto expected = TestUtil.getPostListResponseDto(idUser, idSeller);

        //Act
        PostListResponseDto actual = postService.lastTwoWeeksPostsFromFollowers(idUser, order);

        //Assert
        assertEquals(expected, actual);
    }

    static private Stream<Arguments> orderByDateQueryParamProvider() {
        return Stream.of(arguments("date_asc"), arguments("date_desc"));
    }

    @ParameterizedTest
    @MethodSource("orderByDateQueryParamProvider")
    @DisplayName("T5 Se devuelve una lista cuando el parametro order es valido")
    void whenGivingValidOrderParam_sortPostByDate_ShouldReturnList(String orderQueryParam) throws Exception {
        // Arrange
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        // Act
        List<PostResponseDto> actualPostResponseDtoList = postService.sortPostByDate(postResponseDtoList,orderQueryParam);

        // Assert
        assertEquals(postResponseDtoList, actualPostResponseDtoList);
    }

    @Test
    @DisplayName("T5 Se lanza excepción cuando el parametro order es invalido")
    void whenGivingInvalidOrderParam_sortPostByDate_ShouldThrowInvalidQueryParamValueException() throws Exception {
        // Arrange
        String expectedErrorMessage = "El valor de ordenamiento no es válido";
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        // Act && Assert
        InvalidQueryParamValueException InvalidQueryParamValueException = Assertions.assertThrows(InvalidQueryParamValueException.class, () -> postService.sortPostByDate(postResponseDtoList,"nonExistingOrder"));
        assertEquals(expectedErrorMessage,InvalidQueryParamValueException.getMessage());
    }

    @Test
    @DisplayName("T6 Se obtiene lista de los post de un usuario ordenada ascendentemente.")
    void whenGivingUnorderedList_sortPostByDateAscParam_ShouldReturnOrderedList(){
        // Arrange
        List<PostResponseDto> ascPost = TestUtil.ascPostResponseDTOBuilder(1,2);
        List<PostResponseDto> shuffledList = TestUtil.ascPostResponseDTOBuilder(1,2);
        Collections.shuffle(shuffledList);
        // Act
        List<PostResponseDto> actualList=  postService.sortPostByDate(shuffledList, "date_asc");
        // Assert
        assertEquals(ascPost, actualList);

    }
    @Test
    @DisplayName("T6 Se obtiene lista de los post de un usuario ordenada descendentemente.")
    void whenGivingUnorderedList_sortPostByDateDescParam_ShouldReturnOrderedList(){
        // Arrange
        List<PostResponseDto> ascPost = TestUtil.ascPostResponseDTOBuilder(1,2);
        List<PostResponseDto> ascPostReverse = TestUtil.ascPostResponseDTOBuilder(1,2);
        Collections.reverse(ascPostReverse);
        Collections.shuffle(ascPost);
        // Act
        List<PostResponseDto> actualList=  postService.sortPostByDate(ascPost, "date_desc");

        // Assert
        assertEquals(ascPostReverse, actualList);

    }

}