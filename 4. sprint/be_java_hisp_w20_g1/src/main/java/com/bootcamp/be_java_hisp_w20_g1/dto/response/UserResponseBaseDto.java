package com.bootcamp.be_java_hisp_w20_g1.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserResponseBaseDto {
    private int userId;
    private String userName;
}
