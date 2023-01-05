package com.socialMeli.be_java_hisp_w20_g03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowersDTO {
    private int user_id;
    private String user_name;
    private List<UserDTO> followers;
}
