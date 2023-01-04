package com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFollowersCountDto {

    private int userId;
    private String userName;
    private int followersCount;

}
