package com.bootcamp.be_java_hisp_w20_g7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Follow {

    private int idFollower;
    private int idFollowed;
}
