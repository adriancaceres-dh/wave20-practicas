package com.socialMeli.be_java_hisp_w20_g03.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserFollowersDTO {
    private int user_id;
    private String user_name;
    private List<UserDTO> followers;
}
