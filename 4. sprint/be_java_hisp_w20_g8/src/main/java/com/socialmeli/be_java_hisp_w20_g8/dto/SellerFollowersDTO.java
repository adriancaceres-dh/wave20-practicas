package com.socialmeli.be_java_hisp_w20_g8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class SellerFollowersDTO {
    Integer seller_id;
    String user_name;
    List<UserDTO> followers;
}
