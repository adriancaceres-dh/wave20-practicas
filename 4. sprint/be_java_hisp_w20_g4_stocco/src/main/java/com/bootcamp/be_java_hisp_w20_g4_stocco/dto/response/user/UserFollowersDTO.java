package com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserFollowersDTO {

    private int user_id;
    private String user_name;
    private List<ListedUserDTO> followers;
}
