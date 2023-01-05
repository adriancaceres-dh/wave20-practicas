package com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponseDto extends UserResponseBaseDto {

    public UserResponseDto(int userId, String userName) {
        super(userId, userName);
    }
}
