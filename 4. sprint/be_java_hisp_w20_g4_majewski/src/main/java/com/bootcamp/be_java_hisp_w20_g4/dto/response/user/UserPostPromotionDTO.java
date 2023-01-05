package com.bootcamp.be_java_hisp_w20_g4.dto.response.user;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostPromotionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPostPromotionDTO {
    private int user_id;
    private String user_name;
    private List<ListedPostPromotionDTO> posts;
}
