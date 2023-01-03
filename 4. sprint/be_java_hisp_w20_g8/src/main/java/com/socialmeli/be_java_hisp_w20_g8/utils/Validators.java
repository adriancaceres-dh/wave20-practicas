package com.socialmeli.be_java_hisp_w20_g8.utils;

import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;

public class Validators {
    public static boolean checkValidatorOption(String orderType) {
        return (orderType.equals("name_asc") || orderType.equals("name_desc")||orderType.equals(""));
    }
}
