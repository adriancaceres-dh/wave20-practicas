package com.bootcamp.be_java_hisp_w20_g4.model;


import lombok.Data;

import java.util.HashMap;

@Data
public class Buyer extends User{
    public Buyer(int id, String userName) {
        super(id, userName, new HashMap<>());
    }

}
