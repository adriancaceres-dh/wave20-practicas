package com.socialMeli.be_java_hisp_w20_g03.dto;

import lombok.Data;

@Data
public class UserFollowerCountDTO {
    private int user_id;
    private String user_name;
    private int followers_count;
}
