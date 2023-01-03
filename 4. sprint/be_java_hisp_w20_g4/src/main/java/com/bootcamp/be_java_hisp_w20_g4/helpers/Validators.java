package com.bootcamp.be_java_hisp_w20_g4.helpers;

import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;

public class Validators {

    public static boolean isValidOrder(String order){
        return (order == null) || order.toLowerCase().equals("name_asc") || order.toLowerCase().equals("name_desc");
    }
    public static boolean isValidUser(User user){
        if(user == null){
            throw new RuntimeException("Este usuario no es valido");
        }else return true;
    }
    public static boolean isSeller(User user){
        if(user instanceof Seller){
            return true;
        }else throw new RuntimeException("No se puede consultar los datos de un comprador");
    }
}
