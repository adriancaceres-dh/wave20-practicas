package com.bootcamp.be_java_hisp_w20_g6_villamizar.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class UserModel {
    private int user_id;
    private String user_name;
    private ArrayList<Integer> followers;
    private ArrayList<Integer> followed;
    public UserModel(){
        followers = new ArrayList<>();
        followed= new ArrayList<>();
    }
    public UserModel(int user_id, String user_name){
        this.user_id = user_id;
        this.user_name = user_name;
        followers = new ArrayList<>();
        followed= new ArrayList<>();
    }

    public UserModel(int user_id, String user_name, ArrayList<Integer> followers, ArrayList<Integer> followed) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers = followers;
        this.followed = followed;
    }
}
