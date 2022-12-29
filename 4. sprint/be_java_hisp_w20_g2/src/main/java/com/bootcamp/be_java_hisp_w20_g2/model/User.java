package com.bootcamp.be_java_hisp_w20_g2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;



@AllArgsConstructor
@Data


public class User {
    private int userId;
    private String userName;
    private List<User> followers;
    private List<User> following;
    private List<Post> posts;


}
