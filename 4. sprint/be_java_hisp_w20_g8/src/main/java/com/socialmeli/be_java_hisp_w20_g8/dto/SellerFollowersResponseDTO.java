package com.socialmeli.be_java_hisp_w20_g8.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class SellerFollowersResponseDTO {

    private Integer id;
    private String user_name;

    Set<UserDTO> followers;

}
