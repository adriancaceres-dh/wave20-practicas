package com.bootcamp.be_java_hisp_w20_g6_villamizar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class FollowersCountResponseDto {
    private int user_id;
    private String user_name;
    private int followers_count;

}
