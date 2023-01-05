package com.socialmeli.be_java_hisp_w20_g8.dto.response;


import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponsePostDTO {

    private Integer id_user;
    private String user_name;
    private List<PostDTO> posts;
}
