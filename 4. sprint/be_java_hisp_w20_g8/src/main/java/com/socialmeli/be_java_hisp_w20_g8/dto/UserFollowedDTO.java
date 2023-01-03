package com.socialmeli.be_java_hisp_w20_g8.dto;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserFollowedDTO {
    private int id;
    private String user_name;
    private List<SellerDTO> followed;
}
