package com.socialmeli.be_java_hisp_w20_g8.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class SellerDTO {
    Integer seller_id;
    String user_name;
}
