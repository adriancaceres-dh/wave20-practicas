package com.bootcamp.be_java_hisp_w20_g1.integration;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserResponseBaseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestUser {

    @Autowired
    private MockMvc mockMvc;

    static PostRepository postRepository = new PostRepository();

    static UserFollowersResponseDto ascendantResponseDto;
    static UserFollowersResponseDto descendantResponseDto;

    @BeforeEach
    public void beforEach() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        userResponseDtos.add(new UserResponseDto(3, "kinaMina"));
        userResponseDtos.add(new UserResponseDto(4, "marshallBarshall"));
        userResponseDtos.add(new UserResponseDto(1, "zchanelleHhanelle"));

        List<UserResponseDto> ascendantUsers = userResponseDtos
                .stream()
                .sorted(Comparator.comparing(UserResponseBaseDto::getUserName))
                .collect(Collectors.toList());
        List<UserResponseDto> descendantUsers = userResponseDtos
                .stream()
                .sorted(Comparator.comparing(UserResponseBaseDto::getUserName).reversed())
                .collect(Collectors.toList());

        ascendantResponseDto = new UserFollowersResponseDto();
        ascendantResponseDto.setUserId(2);
        ascendantResponseDto.setUserName("zmohamedDohamed");
        ascendantResponseDto.setFollowers(ascendantUsers);

        descendantResponseDto = new UserFollowersResponseDto();
        descendantResponseDto.setUserId(2);
        descendantResponseDto.setUserName("zmohamedDohamed");
        descendantResponseDto.setFollowers(descendantUsers);
    }

    @Test
    public void shouldGetFollowersListWithDefaultOrder() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/2/followers/list", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(ascendantResponseDto.getUserId()))
                .andExpect(jsonPath("$.user_name").value(ascendantResponseDto.getUserName()))
                .andExpect(jsonPath("$.followers.length()").value(ascendantResponseDto.getFollowers().size()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers[0].user_id").value(ascendantResponseDto.getFollowers().get(0).getUserId()))
                .andExpect(jsonPath("$.followers[0].user_name").value(ascendantResponseDto.getFollowers().get(0).getUserName()))
                .andExpect(jsonPath("$.followers[1].user_id").value(ascendantResponseDto.getFollowers().get(1).getUserId()))
                .andExpect(jsonPath("$.followers[1].user_name").value(ascendantResponseDto.getFollowers().get(1).getUserName()))
                .andExpect(jsonPath("$.followers[2].user_id").value(ascendantResponseDto.getFollowers().get(2).getUserId()))
                .andExpect(jsonPath("$.followers[2].user_name").value(ascendantResponseDto.getFollowers().get(2).getUserName()))
                .andReturn();
    }

    @Test
    public void shouldGetAscendantFollowersList() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/2/followers/list?order=name_asc", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(ascendantResponseDto.getUserId()))
                .andExpect(jsonPath("$.user_name").value(ascendantResponseDto.getUserName()))
                .andExpect(jsonPath("$.followers.length()").value(ascendantResponseDto.getFollowers().size()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers[0].user_id").value(ascendantResponseDto.getFollowers().get(0).getUserId()))
                .andExpect(jsonPath("$.followers[0].user_name").value(ascendantResponseDto.getFollowers().get(0).getUserName()))
                .andExpect(jsonPath("$.followers[1].user_id").value(ascendantResponseDto.getFollowers().get(1).getUserId()))
                .andExpect(jsonPath("$.followers[1].user_name").value(ascendantResponseDto.getFollowers().get(1).getUserName()))
                .andExpect(jsonPath("$.followers[2].user_id").value(ascendantResponseDto.getFollowers().get(2).getUserId()))
                .andExpect(jsonPath("$.followers[2].user_name").value(ascendantResponseDto.getFollowers().get(2).getUserName()))
                .andReturn();
    }

    @Test
    public void shouldGetDescendantFollowersList() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/2/followers/list?order=name_desc", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(descendantResponseDto.getUserId()))
                .andExpect(jsonPath("$.user_name").value(descendantResponseDto.getUserName()))
                .andExpect(jsonPath("$.followers.length()").value(ascendantResponseDto.getFollowers().size()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers[0].user_id").value(descendantResponseDto.getFollowers().get(0).getUserId()))
                .andExpect(jsonPath("$.followers[0].user_name").value(descendantResponseDto.getFollowers().get(0).getUserName()))
                .andExpect(jsonPath("$.followers[1].user_id").value(descendantResponseDto.getFollowers().get(1).getUserId()))
                .andExpect(jsonPath("$.followers[1].user_name").value(descendantResponseDto.getFollowers().get(1).getUserName()))
                .andExpect(jsonPath("$.followers[2].user_id").value(descendantResponseDto.getFollowers().get(2).getUserId()))
                .andExpect(jsonPath("$.followers[2].user_name").value(descendantResponseDto.getFollowers().get(2).getUserName()))
                .andReturn();
    }

    @Test
    public void shouldGetErrorWithInvalidOrderInQueryParamOnFollowersList() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/2/followers/list?order=invalid_order", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isUnprocessableEntity())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El valor de ordenamiento no es válido"))
                .andExpect(jsonPath("$.status").value(HttpStatus.UNPROCESSABLE_ENTITY.value()))
                .andReturn();
    }

    @Test
    public void shouldGetErrorWitInvalidUserIdOnFollowersList() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/200/followers/list", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("El usuario no existe"))
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
                .andReturn();
    }

}
