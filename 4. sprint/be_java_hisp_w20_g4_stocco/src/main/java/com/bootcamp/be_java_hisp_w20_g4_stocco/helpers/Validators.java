package com.bootcamp.be_java_hisp_w20_g4_stocco.helpers;

import com.bootcamp.be_java_hisp_w20_g4_stocco.excepcion.BadRequestException;

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

}
