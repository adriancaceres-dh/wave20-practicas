package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.exception.InvalidQueryParamValueException;
import com.bootcamp.be_java_hisp_w20_g1.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.model.Product;
import com.bootcamp.be_java_hisp_w20_g1.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import com.bootcamp.be_java_hisp_w20_g1.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    void whenGivingValidOrderParam_sortPostByDate_ShouldReturnList(String orderQueryParam) throws Exception {
        // Arrange
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        // Act
        List<PostResponseDto> actualPostResponseDtoList = postService.sortPostByDate(postResponseDtoList,orderQueryParam);

        // Assert
        assertEquals(postResponseDtoList, actualPostResponseDtoList);
    }

    @Test
    void whenGivingInvalidOrderParam_sortPostByDate_ShouldThrowInvalidQueryParamValueException() throws Exception {
        // Arrange
        String expectedErrorMessage = "El valor de ordenamiento no es válido";
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        // Act && Assert
        InvalidQueryParamValueException InvalidQueryParamValueException = Assertions.assertThrows(InvalidQueryParamValueException.class, () -> postService.sortPostByDate(postResponseDtoList,"nonExistingOrder"));
        assertEquals(expectedErrorMessage,InvalidQueryParamValueException.getMessage());
    }

}