package com.bootcamp.be_java_hisp_w20_g7.dto.response;

import com.bootcamp.be_java_hisp_w20_g7.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserFollowedDto {


    private int userId;
    private String userName;

    List<UserDto> followed;
}
