package com.bootcamp.be_java_hisp_w20_g7.dto.response;

import com.bootcamp.be_java_hisp_w20_g7.dto.PostDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserListPostProductPromoDto {

    private int userId;
    private String userName;
    private List<PostDto> listPostPromo;
}
