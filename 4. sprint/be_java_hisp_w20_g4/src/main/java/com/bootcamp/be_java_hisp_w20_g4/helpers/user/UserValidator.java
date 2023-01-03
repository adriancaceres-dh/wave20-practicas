package com.bootcamp.be_java_hisp_w20_g4.helpers.user;

import com.bootcamp.be_java_hisp_w20_g4.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;

public class UserValidator {
    public static void isValidUser(User user){
        if (user == null) throw new RuntimeException("Este usuario no es valido");
    }
    public static void isSeller(User user){
        if(!(user instanceof Seller)) throw new RuntimeException("No se puede consultar los datos de un comprador");
    }
    public static void isNotSameUser(int userId, int userIdToUnfollow){
        if(userId == userIdToUnfollow) throw new BadRequestException("El usuario no puede realizar la operacion sobre si mismo");

    }
}
