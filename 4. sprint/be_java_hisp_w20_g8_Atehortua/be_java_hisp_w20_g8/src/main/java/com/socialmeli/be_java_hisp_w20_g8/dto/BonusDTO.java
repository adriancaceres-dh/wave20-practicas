package com.socialmeli.be_java_hisp_w20_g8.dto;

import com.socialmeli.be_java_hisp_w20_g8.models.Post;

import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BonusDTO {

    private Integer user_id;
    private String user_name;
    private List<Post> posts;
}
