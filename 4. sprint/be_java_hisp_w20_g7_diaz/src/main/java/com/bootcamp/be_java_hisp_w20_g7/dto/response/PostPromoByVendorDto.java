package com.bootcamp.be_java_hisp_w20_g7.dto.response;

import com.bootcamp.be_java_hisp_w20_g7.dto.PostPromoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromoByVendorDto {

    private int userId;
    private String userName;
    private List<PostPromoDto> posts;

}
