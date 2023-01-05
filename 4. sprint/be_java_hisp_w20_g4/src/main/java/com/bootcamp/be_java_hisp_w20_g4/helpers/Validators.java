package com.bootcamp.be_java_hisp_w20_g4.helpers;

import com.bootcamp.be_java_hisp_w20_g4.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;

public class Validators {

    /**
     * Este método controla que el String recibido cumpla las condiciones requeridas
     * @param order - Es el String que especifica el orden
     */
    public static void isValidOrder(String order){
        if (! ((order == null) || order.toLowerCase().equals("name_asc") || order.toLowerCase().equals("name_desc"))) throw new BadRequestException("Parametro de orden incorrecto");
    }

    /**
     * Este método controla que el String recibido cumpla las condiciones requeridas
     * @param order - Es el String que especifica el orden
     */
    public static void isValidDateOrder(String order) {
        if (! ((order == null) || order.toLowerCase().equals("date_asc") || order.toLowerCase().equals("date_desc"))) throw new BadRequestException("Parametro de orden incorrecto");
    }

    /**
     * Este método controla que el String recibido cumpla las condiciones requeridas
     * @param param - Es el String que especifica el id del usuario
     */
    public static void isValidUserParam(Integer param){
        if (param == null) throw new BadRequestException("El parametro de usuario es obligatorio.");
    }

    /**
     * Este método controla que los parametros from y to sean correctos
     * @param from - Es el doube que especifica el rango inicial
     * @param to - Es el double que especifica el rango final
     */
    public static void isValidRangeParams(Double from , Double to){
        if (((from == null) || (to == null))) throw new BadRequestException("Los parametros from y to son obligatorios");
        if (from > to) throw new BadRequestException("El parametro from no puede ser mayor que to");
    }

}
