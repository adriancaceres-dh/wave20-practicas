package com.bootcamp.be_java_hisp_w20_g4.helpers;

import com.bootcamp.be_java_hisp_w20_g4.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;

public class Validators {

    public static void isValidOrder(String order){
        if (! ((order == null) || order.toLowerCase().equals("name_asc") || order.toLowerCase().equals("name_desc"))) throw new BadRequestException("Parametro de orden incorrecto");
    }
    public static void isValidUser(User user){
        if (user == null) throw new RuntimeException("Este usuario no es valido");
    }
    public static void isSeller(User user){
        if(!(user instanceof Seller)) throw new RuntimeException("No se puede consultar los datos de un comprador");
    }

    public static void isValidDateOrder(String order) {
        if (! ((order == null) || order.toLowerCase().equals("date_asc") || order.toLowerCase().equals("date_desc"))) throw new BadRequestException("Parametro de orden incorrecto");
    }
}
