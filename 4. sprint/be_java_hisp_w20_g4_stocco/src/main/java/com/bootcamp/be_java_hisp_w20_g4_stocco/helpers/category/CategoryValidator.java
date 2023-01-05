package com.bootcamp.be_java_hisp_w20_g4_stocco.helpers.category;

import com.bootcamp.be_java_hisp_w20_g4_stocco.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4_stocco.model.Category;
import com.bootcamp.be_java_hisp_w20_g4_stocco.model.User;

public class CategoryValidator {
    /**
     * Este método valida que una categoría no sea nula
     * En caso de que sí sea, lanza exception
     * @param category - La categoría a validar
     */
    public static void isValidCategory(Integer category){
        if (category == null) throw new BadRequestException("Esta categoría no es válida");
    }
}
