package com.bootcamp.be_java_hisp_w20_g4_pereyra.helpers.user;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.User;

public class UserValidator {

    /**
     * Este método valida que un usuario no sea nulo
     * En caso de que si sea, lanza exception
     * @param user - Es el usuario que hay que validar
     */
    public static void isValidUser(User user){
        if (user == null) throw new BadRequestException("Este usuario no es valido");
    }

    /**
     * Este método valida que el usuario sea de tipo Seller
     * En caso de que no sea, lanza exception
     * @param user - Es el usuario que hay que validar
     */
    public static void isSeller(User user){
        if(!(user instanceof Seller)) throw new BadRequestException("No se puede consultar los datos de un comprador");
    }

    /**
     * Este método valida que dos ids no sean iguales
     * @param userId1 - Es el id de un usuario
     * @param userId2 - Es el id de un usuario
     */
    public static void isNotSameUser(int userId1, int userId2){
        if(userId1 == userId2) throw new BadRequestException("El usuario no puede realizar la operacion sobre si mismo");

    }
}
