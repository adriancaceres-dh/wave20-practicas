package com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response;

import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserFollowedDto {

    List<UserDto> followed;
    private int userId;
    private String userName;
}
