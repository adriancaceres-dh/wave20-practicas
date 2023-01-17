package com.bootcamp.be_java_hisp_w20_g6_villamizar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class FollowersListResponseDto {

    private int user_id;
    private String user_name;
    private List<UserResponseDto> followers;

}

