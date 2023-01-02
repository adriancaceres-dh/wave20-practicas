package com.bootcamp.be_java_hisp_w20_g4.helpers;

public class Validators {

    public static boolean isValidOrder(String order){
        return (order == null) || order.toLowerCase().equals("name_asc") || order.toLowerCase().equals("name_desc");
    }
}
