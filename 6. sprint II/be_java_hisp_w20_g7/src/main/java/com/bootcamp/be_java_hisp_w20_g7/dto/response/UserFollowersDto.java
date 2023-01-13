package com.bootcamp.be_java_hisp_w20_g7.dto.response;

import com.bootcamp.be_java_hisp_w20_g7.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserFollowersDto {

    private int userId;
    private String userName;
    List<UserDto> followers;
}
