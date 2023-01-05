package com.socialmeli.be_java_hisp_w20_g8.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostListDTO {
    int user_id;
    String user_name;
    List<PromoPostRequestDTO> posts;
}
