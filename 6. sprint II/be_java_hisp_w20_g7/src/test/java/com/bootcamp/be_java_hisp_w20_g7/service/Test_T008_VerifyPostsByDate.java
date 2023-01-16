package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.repository.FollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.stream.Stream;

import static com.bootcamp.be_java_hisp_w20_g7.utils.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Test_T008_VerifyPostsByDate {
    @Mock
    private PostRepository postRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private FollowRepository followRepository;
    @InjectMocks
    private PostService postService;

    static Clock clock;

    public static Stream<Arguments> postWithAscAndDescOrder() {
        return Stream.of(
                arguments(postDtoAscOrder(), "date_asc"), arguments(postDtoDescOrder(), "date_desc"));
    }
    // Configurar el localDate en una fecha exacta
    @BeforeAll
    static void setupClock() {
        clock = Clock.fixed(
                Instant.parse("2023-01-02T10:05:23.653Z"),
                ZoneId.of("UTC"));

        Mockito.mockStatic(Clock.class)
                .when(Clock::systemUTC).thenReturn(clock);
    }

    //Muestras las fechas dentro del rango sugerido (dos semanas)
    @Test
    void t0008LastTwoWeekPosts(){
        when(userRepository.findById(1)).thenReturn(users().get(0));
        when(followRepository.findAll()).thenReturn(followListToTest());
        when(postRepository.findAll()).thenReturn(postListTestToTest0008());
        UserPostFollowedDto userPostFollowedDtoActual = postService.postUsersFollowed(1, "date_asc");
        Assertions.assertEquals(postDtoBetween15Days(), userPostFollowedDtoActual.getPosts() );
    }
}
