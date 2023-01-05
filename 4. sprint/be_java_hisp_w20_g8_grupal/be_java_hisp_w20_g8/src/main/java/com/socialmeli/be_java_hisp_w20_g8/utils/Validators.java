package com.socialmeli.be_java_hisp_w20_g8.utils;

public class Validators {
    public static boolean checkValidatorOptionName(String orderType) {
        return (orderType.equals("name_asc") || orderType.equals("name_desc")||orderType.equals(""));
    }
    public static boolean checkValidatorOptionDate(String orderType) {
        return (orderType.equals("date_asc") || orderType.equals("date_desc")||orderType.equals(""));
    }


}
