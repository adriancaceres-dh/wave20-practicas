package com.bootcamp.be_java_hisp_w20_g7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private int userId;
    private String userName;

}
